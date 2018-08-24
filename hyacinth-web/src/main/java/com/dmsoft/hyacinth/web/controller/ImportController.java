package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.utils.RecordHistory;
import com.dmsoft.hyacinth.web.utils.GetRoleNameUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class ImportController {
    private int successCount, failedCount;

    @Autowired
    private StaffService staffService;

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/import")
    public String impot() {
        return "import";
    }


    /**
     * 导入员工csv文件数据
     *
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/import/Staff", method = RequestMethod.POST)
    public String InportStaff(@RequestParam("filename") MultipartFile multipartFile) throws IOException {
        successCount = 0;
        failedCount = 0;
        if (!isCsv(multipartFile.getOriginalFilename())) {
            return multipartFile.getOriginalFilename() + "不是csv格式的文件";
        }

        File file = null;
        file = File.createTempFile(multipartFile.getOriginalFilename(), ".csv");
        multipartFile.transferTo(file);
        file.deleteOnExit();

        if (!validateFileExit(file.getPath())) {
            return file.getPath() + "文件不存在";
        }

        // 忽略前几行标题
        int ignoreRows = 1;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            if (ignoreRows > 0)
                for (int i = 0; i < ignoreRows; i++) {
                    line = br.readLine();
                }

            staffService.deleteall();
            while ((line = br.readLine()) != null) {
                if (line.trim() != null) {
                    String[] pills = line.split(";");
                    if (staffService.insertStaff(Long.valueOf(pills[0]), pills[1], pills[2], "", pills[5], pills[6], pills[4], pills[3], pills[7]) == 1)
                        successCount++;
                    else failedCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();

            User user = (User) SecurityUtils.getSubject().getPrincipal();
            if (successCount == 0)
                RecordHistory.RecordHistory(user.getLogin_name(), successCount + "条", RecordHistory.IMPORT_STAFF_BASE_INFO, "失败");
            else
                RecordHistory.RecordHistory(user.getLogin_name(), successCount + "条", RecordHistory.IMPORT_STAFF_BASE_INFO, "成功");
            return "import success: " + successCount + " records, failed: " + failedCount + " records.";
        }
    }

    /**
     * 导入薪资csv文件数据
     *
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/import/Salary", method = RequestMethod.POST)
    public String InportSalary(@RequestParam("filename2") MultipartFile multipartFile) throws IOException {
        successCount = 0;
        failedCount = 0;
        if (!isCsv(multipartFile.getOriginalFilename())) {
            return multipartFile.getOriginalFilename() + "不是csv格式的文件";
        }

        File file = File.createTempFile(multipartFile.getOriginalFilename(), ".csv");
        multipartFile.transferTo(file);
        file.deleteOnExit();
//        System.out.println(file.getPath());

        if (!validateFileExit(file.getPath())) {
            return file.getPath() + "文件不存在";
        }
        int ignoreRows = 1;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            if (ignoreRows > 0)
                for (int i = 0; i < ignoreRows; i++)
                    line = br.readLine();
            salaryService.deleteall();
            while ((line = br.readLine()) != null) {
                if (line.trim() != null) {
                    String[] pills = line.split(";");

                    for (int a = 0; a < pills.length; a++) {
                        if ("".equals(pills[a]))
                            pills[a] = "0";
                    }

                    if (salaryService.insert(pills[0], pills[1], pills[2], pills[3], pills[4], pills[5], pills[6]
                            , pills[7], pills[8], pills[9], pills[10], pills[11], pills[12], pills[13]
                            , pills[14], pills[15], pills[16], pills[17], pills[18]
                            , pills[19], pills[20], pills[21], pills[22], pills[23], pills[24]
                            , pills[25], pills[26], pills[27], pills[28]
                            , pills[29]) == 1)
                        successCount++;
                    else failedCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            if (successCount == 0)
                RecordHistory.RecordHistory(user.getLogin_name(), successCount + "条", RecordHistory.IMPORT_STAFF_MONEY_INFO, "失败");
            else
                RecordHistory.RecordHistory(user.getLogin_name(), successCount + "条", RecordHistory.IMPORT_STAFF_MONEY_INFO, "成功");
            return "import success: " + successCount + " records, failed: " + failedCount + " records.";
        }
    }


    /**
     * 检查文件是否存在，存在返回true，不存在返回false
     *
     * @param filePath 文件完整路径
     * @return boolean
     */
    private static boolean validateFileExit(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * 是否是csv格式的文件，返回true是csv格式，不是则返回false
     *
     * @param filePath 文件完整路径
     * @return boolean
     */
    private static boolean isCsv(String filePath) {
        return filePath.matches("^.+\\.(?i)(csv)$");
    }

    @ModelAttribute(name = "role")
    public String role() {
        return GetRoleNameUtil.getCurrentUserRoleName();
    }
}
