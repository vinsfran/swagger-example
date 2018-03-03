package com.example.swaggerexample.resource;

import com.example.swaggerexample.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
@Api(value = "User Resource REST EndPoint", description = "Shows the user info")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<User> users = Arrays.asList(
            new User("Sam", 2000L),
            new User("Peter", 1000L)
    );

    @GetMapping
    public List<User> list() {
        return this.users;
    }

    @GetMapping("/{userName}")
    public User get(@PathVariable("userName") final String userName) {
        return new User(userName, 1500L);
    }

    @ApiOperation(value = "Returns Hello world Post")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insert(@RequestBody Map<String, String> body) {
        return new ResponseEntity<>("Body param map: " + body, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns Hello world Put")
    @PutMapping()
    public String update(@RequestBody final String hello) {
        return "UPDATE " + hello;
    }

    @ApiOperation(value = "Returns Hello world Delete")
    @DeleteMapping()
    public String delete(@RequestBody final String hello) {
        return "DELETE " + hello;
    }

    @GetMapping("/userPDF")
    public void userPdf(HttpServletResponse response) {
        try {
            InputStream jasperStream = this.getClass().getResourceAsStream("/report/report.jrxml");
            JasperDesign design = JRXmlLoader.load(jasperStream);
            JasperReport report = JasperCompileManager.compileReport(design);
            Map<String, Object> parameterMap = new HashMap();
            List<User> listaUsuarios = this.users;
            JRDataSource jRDataSource = new JRBeanCollectionDataSource(listaUsuarios);
            parameterMap.put("datasource", jRDataSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameterMap, jRDataSource);
            response.setContentType("application/x-pdf");
            response.setHeader("Content-Disposition", "inline: filename=users.pdf");
            final OutputStream outputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (JRException ex) {
            log.info("No se encuentra archivo jrxml");
        } catch (IOException ex) {
            log.info("Problema con el OutputStream ");
        }
    }

    @GetMapping("/userXLS")
    public void userXls(HttpServletResponse response) {
        try {
            InputStream jasperStream = this.getClass().getResourceAsStream("/report/report.jrxml");
            JasperDesign design = JRXmlLoader.load(jasperStream);
            JasperReport report = JasperCompileManager.compileReport(design);
            Map<String, Object> parameterMap = new HashMap();
            List<User> listaUsuarios = this.users;
            JRDataSource jRDataSource = new JRBeanCollectionDataSource(listaUsuarios);
            parameterMap.put("datasource", jRDataSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameterMap, jRDataSource);
            response.setContentType("application/x-xls");
            response.setHeader("Content-Disposition", "inline: filename=users.xls");
            final OutputStream outputStream = response.getOutputStream();
            
            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporterXLS.exportReport();
        } catch (JRException ex) {
            log.info("No se encuentra archivo jrxml");
        } catch (IOException ex) {
            log.info("Problema con el OutputStream ");
        }
    }

}
