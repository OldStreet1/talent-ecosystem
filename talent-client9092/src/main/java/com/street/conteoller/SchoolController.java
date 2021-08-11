package com.street.conteoller;

import com.street.bean.University;
import com.street.bean.User;
import com.street.service.UniversityService;
import com.street.service.impl.UniversityImpl;
import com.street.service.impl.UserServiceImpl;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @version 1.0
 * @author: xiaozheng
 * @date: 2021/7/26 15:54
 * @desc:
 */
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private UniversityImpl UniversityService;
    @Autowired
    private UserServiceImpl userService;

    University university = new University();
    User user=new User();


    //    注册
    @RequestMapping("/getReg")
    public @ResponseBody
    String getReg(@Param("university_name") String university_name,
                  @Param("university_code") String university_code,
                  @Param("corporate_ID_number") String corporate_ID_number,
                  @Param("university_password") String university_password,
                  @Param("university_profile") String university_profile) {
        System.out.println(">>>>>>>>>>>>>1111<<<<<<<<<<<<<<<<<<");

        university.setUniversity_name(university_name);
        university.setUniversity_code(university_code);
        university.setUniversity_corporate_ID_number(corporate_ID_number);
        university.setUniversity_password(university_password);
        university.setUniversity_profile(university_profile);

        int i = UniversityService.checkReg(university);
        if (i == 1) {
            System.out.println("注册成功");
            return "success";
        } else {
            return "0";
        }
    }

    //    登录
    @RequestMapping("/getLogin")
    public @ResponseBody
    String getLogin(String corporate_ID_number, String university_password, HttpServletRequest request) {
        university.setUniversity_corporate_ID_number(corporate_ID_number);
        university.setUniversity_password(university_password);
        List<University> universities = UniversityService.checkLogin(university);

        if (!universities.isEmpty()) {
//            把法人身份证存进session里
            HttpSession session = request.getSession();
            session.setAttribute("data", corporate_ID_number);
            return "success";
        } else {
            return "0";
        }
    }

    //查询学校名字
    @RequestMapping("/schoolname")
    public String schoolname(String university_corporate_ID_number, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String data = (String) session.getAttribute("data");
        university_corporate_ID_number = data;
        System.out.println(university_corporate_ID_number);
        university.setUniversity_corporate_ID_number(university_corporate_ID_number);
        List<University> filename222 = UniversityService.fileName(university);
        if (!filename222.isEmpty()) {
            System.out.println(filename222);

            System.out.println(filename222.get(0).getUniversity_name());
            String schoolName=filename222.get(0).getUniversity_name();
            HttpSession session1 = request.getSession();
            session1.setAttribute("school", schoolName);
            return "filename222";
        } else {
            return "0";
        }
    }

//    上传文件
@RequestMapping("/upload")
public Map<String, Object> upload(@RequestParam("file") MultipartFile file,
                                  HttpServletRequest request) throws IOException {
    HttpSession session1 = request.getSession();
    String school = (String) session1.getAttribute("school");
    System.out.println(school);

//    System.err.println(phoneNumber);
    System.out.println(System.getProperty("user.dir") + "/upload");
    Map<String, Object> map = new HashMap<>();
    if (file != null) {  //如果获取到的文件不为空
        String filename = file.getOriginalFilename();
        // 上传文件存储目录 //获取当前的路径
        String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/upload/" + school +"/";
        String pathname = UPLOAD_DIRECTORY;
        File file_server = new File(pathname, filename);  //创建文件对象
        if (!file_server.getParentFile().exists()) {
            //如果文件父目录不存在，就创建这样一个目录
            file_server.getParentFile().mkdirs();
            System.out.println("创建目录" + file);
            System.out.println("文件路径"+pathname+filename);
        } else {  //如果父文件夹已经存在

        }
        file.transferTo(file_server);
        map.put("status", true);
        map.put("msg", "上传文件成功");
        HttpSession session = request.getSession();
        session.setAttribute("luj", pathname+filename);


    } else {   //如果获取到的文件为空
        map.put("status", false);
        map.put("msg", "上传文件失败");
        map.put("reason", "文件为空");
    }
    return map;
}

//解析
    @RequestMapping("/jiex")
    public ArrayList<User> jiex(HttpServletRequest request) throws IOException, BiffException {
        HttpSession session = request.getSession();
        String luj = (String) session.getAttribute("luj");
        System.out.println("拿到"+luj);
        ArrayList<User> users = new ArrayList<User>();
        //获取excel文件
        File file = new File(luj);
        //转化成输入流
        InputStream input = new FileInputStream(file);
        //创建Workbook对象
        Workbook workbook = Workbook.getWorkbook(input);
        //获取第一张表（sheet1）
        Sheet readsheet = workbook.getSheet(0);
        //获取sheet表中的总行数
        int rsRows = readsheet.getRows();
        //获取sheet表中的总列数
        int rsColumns = readsheet.getColumns();
        System.out.println("总的行数：" + rsRows);
        System.out.println("总的列数：" + rsColumns);

        //创建集合把单元格中的数据存储起来
        ArrayList<String> list = new ArrayList<String>();//创建两个集合是希望按照行数进行存储
        ArrayList<String> list1 = new ArrayList<String>();//
        for (int i=1;i<rsRows;i++){
            User user =new User();
            for (int j=0;j<rsColumns;j++){
                Cell cell=readsheet.getCell(j,i);
                String str=cell.getContents();
                list.add(str);
                System.out.println("第" + (i + 1) + "行" + "第" + (j + 1) + "列的值是：" + str);
                if (j == 0) {
                    user.setUser_id(Integer.parseInt(str));
                } else if (j == 1) {
                    user.setUser_name(str);
                } else if (j == 2) {
                    user.setUser_pwd(str);
                } else if (j == 3) {
                    user.setUser_id_card(str);
                } else if (j == 4) {
                    user.setUser_nation(str);
                } else if (j == 5) {
                    user.setUser_sex(str);
                }else if (j == 6) {
                    user.setUserage(str);
                } else if (j == 7) {
                    user.setUser_date_birth(str);
                } else if (j == 8) {
                    user.setUser_telephone(str);
                } else if (j == 9) {
                    user.setUser_email(str);
                }else if (j == 10) {
                    user.setUser_school_name(str);
                }else if (j == 11) {
                    user.setUser_major(str);
                } else if (j == 12) {
                    user.setUser_education(str);
                } else if (j == 13) {
                    user.setUser_residence(str);
                } else if (j == 14) {
                    user.setUser_graduation_time(str);
                }
            }
            users.add(user);
            System.out.println(user);
            int j = UniversityService.checkAdd(users);
        }

        return users;
    }
    //查询学生用户
    @RequestMapping("/queryUser")
    public List queryUser(HttpServletRequest request){
        HttpSession session1 = request.getSession();
        String school = (String) session1.getAttribute("school");
        System.out.println(school);
        List list=UniversityService.queryUser(user.setUser_school_name(school));
        return list;
    }
    //查询专业
    @RequestMapping("/queryMajor")
    public List queryMajor(String user_school_name,HttpServletRequest request){
        HttpSession session1 = request.getSession();
        String school = (String) session1.getAttribute("school");
        user_school_name=school;
        System.out.println(">>>>>>>"+user_school_name);
        List list1=UniversityService.queryMajor(user.setUser_school_name(user_school_name));
        System.out.println("专业集合"+list1.size());
        return list1;
    }

    //根据专业查学生
    @RequestMapping("/screenUser")
    public List screenUser(String user_major,String user_school_name,HttpServletRequest request ){
        HttpSession session1 = request.getSession();
        String school = (String) session1.getAttribute("school");
        System.out.println(school);
        if (user_major!="全部"){
            user.setUser_major(user_major);
            user.setUser_school_name(school);
            List list2 = UniversityService.screenUser(user);
            return list2;
        }
        return null;
    }




}
