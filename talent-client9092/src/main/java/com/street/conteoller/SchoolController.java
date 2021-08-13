package com.street.conteoller;

import com.street.bean.University;
import com.street.bean.User;
import com.street.service.impl.UniversityImpl;
import com.street.service.impl.UserServiceImpl;
import jdk.nashorn.internal.runtime.JSONFunctions;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


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


    private final static String XLS = "xls";
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
            file_server.getParentFile().delete();
            file_server.getParentFile().mkdirs();
            System.out.println("222创建目录" + file);
            System.out.println("222文件路径"+pathname+filename);
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
    public ArrayList<User> jiex( HttpServletRequest request) throws IOException, BiffException {
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
                if(j==0){
                    user.setUser_id(Integer.parseInt(str));
                }else if (j == 1) {
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
                    System.out.println("获取时间" + new Date());
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
                    System.out.println("格式化输出：" + sdf.format(d));
                    sdf.format(d);
                    user.setCreate_time(sdf.format(d));
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
            user.setUser_major(user_major);
            user.setUser_school_name(school);
            List list2 = UniversityService.screenUser(user);
            return list2;
    }
    //高校简介
    @RequestMapping("/queryProfile")
    public List queryProfile(HttpServletRequest request){
        HttpSession session2 = request.getSession();
        String school = (String) session2.getAttribute("school");
        System.out.println(school);
        university.setUniversity_name(school);
        List listProfile=UniversityService.queryProfile(university);
        System.out.println(school+"简介，集合"+listProfile);
        return listProfile;
    }

    //下载
    @RequestMapping("/downloadExcel")
    public void downloadExcel(String user_major, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session3 = request.getSession();
        String school = (String) session3.getAttribute("school");
        System.out.println(school);
        System.out.println("拿到了前端传过来的"+user_major);
        //1.创建工作簿
        HSSFWorkbook wb=new HSSFWorkbook();
        //1.1创建合并单元格对象
        CellRangeAddress callRangeAddress = new CellRangeAddress(0,1,0,12);//起始行,结束行,起始列,结束列
        //1.2头标题样式
        HSSFCellStyle headStyle = createCellStyle(wb,(short)16);
        //1.3列标题样式
        HSSFCellStyle style = createCellStyle(wb,(short)12);
        //2.创建工作表
        HSSFSheet sheet=wb.createSheet("Sheet1");
        //2.1加载合并单元格对象
        sheet.addMergedRegion(callRangeAddress);
        //设置默认列宽
        sheet.setDefaultColumnWidth(10);
        //3.创建行
        //3.1创建头标题行;并且设置头标题
        HSSFRow head=sheet.createRow(0);
        HSSFRow head2=sheet.createRow(1);
        head.setHeight((short) (30*30));
        head2.setHeight((short) (30*30));
        HSSFCell headCell= head.createCell(0);
        //加载单元格样式并赋值
        headCell.setCellStyle(headStyle);
        headCell.setCellValue("用户列表");
        //3.2创建列标题;并且设置列标题
        HSSFRow row=sheet.createRow(2);
        row.setHeight((short) (20*25));
        HSSFCell cell=row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("密码");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("身份证");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("民族");
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue("性别");
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue("年龄");
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue("出生年月");
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellValue("联系电话");
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellValue("邮箱");
        cell.setCellStyle(style);
        cell = row.createCell(10);
        cell.setCellValue("学校名称");
        cell.setCellStyle(style);
        cell = row.createCell(11);
        cell.setCellValue("专业");
        cell.setCellStyle(style);
        cell = row.createCell(12);
        cell.setCellValue("学历");
        cell.setCellStyle(style);
        cell = row.createCell(13);
        cell.setCellValue("居住地");
        cell.setCellStyle(style);
        cell = row.createCell(14);
        cell.setCellValue("毕业时间");
        cell.setCellStyle(style);
        Map<String,Object> map=new HashMap<>();
        map.put("uuid",null);
        map.put("name",null);
        map.put("position",null);
        if(user_major=="全部") {
            List list = UniversityService.queryUser(user.setUser_school_name(school));
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 3);
                User user = (User) list.get(i);
                row.createCell(0).setCellValue(((User) list.get(i)).getUser_id());//id
                row.createCell(1).setCellValue(user.getUser_name());//用户名
                row.createCell(2).setCellValue(user.getUser_pwd());//密码
                row.createCell(3).setCellValue(user.getUser_id_card());//身份证
                row.createCell(4).setCellValue(user.getUser_nation());//民族
                row.createCell(5).setCellValue(user.getUser_sex());//性别
                row.createCell(6).setCellValue(user.getUserage());//年龄
                row.createCell(7).setCellValue(user.getUser_date_birth());//出生年月
                row.createCell(8).setCellValue(user.getUser_telephone());//联系电话
                row.createCell(9).setCellValue(user.getUser_email());//邮箱
                row.createCell(10).setCellValue(user.getUser_school_name());//学校名称
                row.createCell(11).setCellValue(user.getUser_major());//专业
                row.createCell(12).setCellValue(user.getUser_education());//学历
                row.createCell(13).setCellValue(user.getUser_residence());//居住地
                row.createCell(14).setCellValue(user.getUser_graduation_time());//毕业时间
            }
        }else {
            user.setUser_major(user_major);
            user.setUser_school_name(school);
            List list2 = UniversityService.screenUser(user);
            for (int j = 0;j < list2.size(); j++) {
                row = sheet.createRow(j + 3);
                User user = (User) list2.get(j);
                row.createCell(0).setCellValue(user.getUser_id());//id
                row.createCell(1).setCellValue(user.getUser_name());//用户名
                row.createCell(2).setCellValue(user.getUser_pwd());//密码
                row.createCell(3).setCellValue(user.getUser_id_card());//身份证
                row.createCell(4).setCellValue(user.getUser_nation());//民族
                row.createCell(5).setCellValue(user.getUser_sex());//性别
                row.createCell(6).setCellValue(user.getUserage());//年龄
                row.createCell(7).setCellValue(user.getUser_date_birth());//出生年月
                row.createCell(8).setCellValue(user.getUser_telephone());//联系电话
                row.createCell(9).setCellValue(user.getUser_email());//邮箱
                row.createCell(10).setCellValue(user.getUser_school_name());//学校名称
                row.createCell(11).setCellValue(user.getUser_major());//专业
                row.createCell(12).setCellValue(user.getUser_education());//学历
                row.createCell(13).setCellValue(user.getUser_residence());//居住地
                row.createCell(14).setCellValue(user.getUser_graduation_time());//毕业时间
            }
        }
        OutputStream os= response.getOutputStream();
        String fileName=user_major+"学生信息表.xls";
//        String path="C:\\11\\"+fileName+".xls";
        String UPLOAD_DIRECTORY = "C:" + "/downLoad/" + school +"/";
        String pathname = UPLOAD_DIRECTORY;
        File file_server = new File(pathname, fileName);  //创建文件对象
        if (!file_server.getParentFile().exists()) {
            //如果文件父目录不存在，就创建这样一个目录
            file_server.getParentFile().mkdirs();
            System.out.println("创建目录" + pathname);
            System.out.println("文件路径"+pathname+fileName);
        }
        OutputStream outputStream=new FileOutputStream(pathname+fileName);
        System.out.println(pathname+fileName);
        response.reset();
        wb.write(outputStream);
        wb.close();
        os.close();
    }
    //这个方法是创建表格样式的
    private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontsize) {

        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //创建字体
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints(fontsize);
        //加载字体
        style.setFont(font);
        //设置行高
        return style;
    }
}
