package task.project.ultra.controller;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import task.project.ultra.dao.impl.IEmployeeDao;
import task.project.ultra.dao.impl.IPositionDao;
import task.project.ultra.model.Employee;
import task.project.ultra.model.Position;
import task.project.ultra.request.ReqEmployee;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ultra")
public class EmployeeController {

    @Autowired
    IEmployeeDao employeeDao;
    @Autowired
    IPositionDao positionDao;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView home(@RequestParam(value = "successMsg", required = false) String successMsg) {
        ModelAndView model = new ModelAndView("index");
        try {
            List<Employee> employeeList = employeeDao.getEmployeeList();
            model.addObject("employeeList", employeeList);
            model.addObject("successMsg", successMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/newEmployeeWithExcel", method = RequestMethod.GET)
    public ModelAndView newEmployeeWithExcel(@RequestParam(value = "errorMsg", required = false) String errorMsg) {
        ModelAndView model = new ModelAndView("newEmployee");
        try {
            List<Position> positionList = positionDao.positionList();
            model.addObject("positionList", positionList);
            model.addObject("errorMsg", errorMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }


    @PostMapping("/importEmployeeWithExcel")
    public RedirectView importOfflineBillingData(@RequestParam("file") MultipartFile reapExcelDataFile, @RequestParam("situationName") Long situationName) throws IOException {
        RedirectView model = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);
            for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
                ReqEmployee employee = new ReqEmployee();
                XSSFRow row = worksheet.getRow(i);
                DataFormatter formatter = new DataFormatter();
                employee.setName(formatter.formatCellValue(row.getCell(0)));
                employee.setSurname(formatter.formatCellValue(row.getCell(1)));
                employee.setFatherName(formatter.formatCellValue(row.getCell(2)));
                employee.setGender(formatter.formatCellValue(row.getCell(3)));
                employee.setDob(formatter.formatCellValue(row.getCell(4)));
                employee.setBeginWorkDate(formatter.formatCellValue(row.getCell(5)));
                Position position = positionDao.getPositionNameById(situationName);
                employee.setPosition(position);
                employeeDao.addEmployeeWithExcel(employee);
            }
            model = new RedirectView("/task/ultra/home");
            model.addStaticAttribute("successMsg", "Data has been successfully added!");
        } catch (Exception ex) {
            model = new RedirectView("/task/ultra/newEmployeeWithExcel");
            model.addStaticAttribute("errorMsg", "Problem! Data has not been added");
            ex.printStackTrace();
        }
        return model;
    }

}
