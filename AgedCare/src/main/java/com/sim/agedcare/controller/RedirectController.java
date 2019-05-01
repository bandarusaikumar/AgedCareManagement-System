package com.sim.agedcare.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sim.agedcare.entity.AdminContact;
import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.HealthRecord;
import com.sim.agedcare.entity.Nurse;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.entity.User;
import com.sim.agedcare.service.AdminContactService;
import com.sim.agedcare.service.HealthRecordService;
import com.sim.agedcare.service.LoginService;
import com.sim.agedcare.service.PatientService;
import com.sim.agedcare.vo.ContactAdmin;
import com.sim.agedcare.vo.GetDocInfoBean;
import com.sim.agedcare.vo.LoginBean;
import com.sim.agedcare.vo.PatientLoginBean;


@Controller
@ComponentScan(basePackages="com.sim.agedcare")
public class RedirectController {
	
	public static int HEALTH_COUNT=0;
	@Autowired
	PatientService patientService;
	
	@Autowired
	AdminContactService adminContactService;
	
	@Autowired
	HealthRecordService healthRecordService;
	
	@Autowired
	LoginService loginService;
	
	@Value("${user.username}")
	public  String username;	
	
	@Value("${user.password}")
	public  String password;
	
	 @Autowired
	 public JavaMailSender sender;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String loginPage(Model model) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		loginService.save(user);
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
	    return "login";
	}
	@RequestMapping(value = { "/alogin"}, method = RequestMethod.GET)
	public String aLoginPage(Model model) {
		List<Patient> patients=patientService.getPatients();		
		model.addAttribute("patients", patients);
	    return "adminlogin"; 
	}
	
	
	@RequestMapping(value = { "/adminhome"}, method = RequestMethod.GET)
	public String aHomePage(Model model) {
		List<Patient> patients=patientService.getPatients();		
		model.addAttribute("patients", patients);
	    return "adminhome"; 
	}
	@RequestMapping(value = { "/patienthome/{id}"}, method = RequestMethod.GET)
	public String PHomePage(Model model,@PathVariable("id") long id) {
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "patienthome"; 
	}
	@RequestMapping(value = { "/plogin"}, method = RequestMethod.POST)
	public String patientLoginPage(Model model,PatientLoginBean patientLoginBean) {
		String redirect="";
		Patient patient=loginService.getPatient(patientLoginBean);
		System.out.println(patient+"|patient::"+patientLoginBean);
		if(patient!=null) {
			System.out.println(patient);
			//Patient patient=patientService.getPatientById(patient.getPatientId());		
			model.addAttribute("patient", patient);
			model.addAttribute("id", patient.getPatientId());
			redirect="patienthome";
		}else {
			model.addAttribute("msg","Invalid Username and Password" );
			redirect="login";
			System.out.println("Invalid Username and Password "+patientLoginBean);
		}
		
	    return redirect;
	}
	
	@RequestMapping(value = { "/adminlogin"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String adminLoginPage(Model model,LoginBean loginBean) {
		System.out.println(loginBean);
		String redirect="";
		User user=loginService.getUser(loginBean);
		if(user!=null) {
			List<Patient> patients=patientService.getPatients();		
			model.addAttribute("patients", patients);
			redirect="adminhome";
		}else {
			model.addAttribute("msg","Invalid Username and Password" );
			redirect="adminlogin";
		}
		
	    return redirect;
	}
	@RequestMapping(value = { "/nursevisiting"}, method = RequestMethod.GET)
	public String nursePage(Model model) {
		List<PatientRelation> patientRelations=patientService.getPatientRelations();	
		model.addAttribute("patientRelations", patientRelations);
	    return "nursevisiting";
	}
	@RequestMapping(value = { "/nursevisiting/{id}"}, method = RequestMethod.GET)
	public String pNursePage(Model model,@PathVariable("id") long id) {
		List<PatientRelation> patientRelations=patientService.getPatientRelationById(id);	
		model.addAttribute("patientRelations", patientRelations);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "pnursevisiting";
	}
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
	public String logout(Model model) {		
	    return "login";
	}
	@RequestMapping(value = { "/admincontact"}, method = RequestMethod.GET)
	public String admincontact(Model model) {
		List<AdminContact> adminContacts=adminContactService.getAdminContacts();
		model.addAttribute("adminContacts", adminContacts);
	    return "viewcontactadmin";
	}
	@RequestMapping(value = { "/contactadminedit"}, method = RequestMethod.GET)
	public String admincontactedit(Model model,@RequestParam("caid") long caid,ContactAdmin contactAdmin) {
		AdminContact adminContact=adminContactService.getAdminContact(caid);				
		model.addAttribute("adminContact", adminContact);
	    return "contactadmin";
	}	
	@RequestMapping(value = { "/contactadmin/{adid}"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String contactAdmin(Model model, ContactAdmin contactAdmin,@PathVariable("adid") String adid) {
		System.out.println(contactAdmin);
		AdminContact adminContact=adminContactService.getAdminContact(Long.parseLong(adid));
		//adminContact.setPatientMailId(contactAdmin.getPatientMailId());
		adminContact.setAnswer(contactAdmin.getAnswer());
		//adminContact.setQuery(contactAdmin.getQuery());
		adminContactService.save(adminContact);
		List<AdminContact> adminContacts=adminContactService.getAdminContacts();
		model.addAttribute("adminContacts", adminContacts);
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(adminContact.getPatientMailId());
            helper.setText(contactAdmin.getAnswer());
            helper.setSubject(adminContact.getQuery());
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        		
	    return "viewcontactadmin";
	}
	
	
	
	@RequestMapping(value = { "/admincontact/{id}"}, method = RequestMethod.GET)
	public String padmincontact(Model model,@PathVariable("id") long id) {
		List<AdminContact> adminContacts=adminContactService.getPAdminContacts(id);
		model.addAttribute("adminContacts", adminContacts);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "pviewcontactadmin";
	}
	@RequestMapping(value = { "/admincontactadd/{id}"}, method = RequestMethod.GET)
	public String padmincontact1(Model model,@PathVariable("id") long id) {
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "pcontactadmin";
	}
	@RequestMapping(value = { "/pcontactadmin"}, method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String pcontactAdmin(Model model, ContactAdmin contactAdmin) {
		System.out.println(contactAdmin);
		AdminContact adminContact=new AdminContact();
		adminContact.setPatientMailId(contactAdmin.getPatientMailId());
		adminContact.setQuery(contactAdmin.getQuery());
		adminContact.setPatientId(contactAdmin.getPatientId());
		adminContactService.save(adminContact);
		List<AdminContact> adminContacts=adminContactService.getPAdminContacts(contactAdmin.getPatientId());
		model.addAttribute("adminContacts", adminContacts);        		
	    return "pviewcontactadmin";
	}
	
	
	
	
	@RequestMapping(value = { "/getinformationdoctor"}, method = RequestMethod.GET)
	public String getinformDoc(Model model) {		
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords();
		model.addAttribute("healthRecords", healthRecords);		
	    return "viewhealthrecords";
	}
	@RequestMapping(value = { "/getinformationdoctor/{id}"}, method = RequestMethod.GET)
	public String pgetinformDoc(Model model,@PathVariable("id") long id) {		
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords(id);
		List<GetDocInfoBean> getDocInfoBeans=healthRecordService.getDocInfoBeans(healthRecords); 
		System.out.println("getDocInfoBeans::"+getDocInfoBeans);
		model.addAttribute("getDocInfoBeans", getDocInfoBeans);
		Patient patient=patientService.getPatientById(id);		
		model.addAttribute("patient", patient);
		model.addAttribute("id", patient.getPatientId());
	    return "pviewhealthrecords";
	}
	@RequestMapping(value = { "/healthrecord/addhealthrecord"}, method = RequestMethod.GET)
	public String addHealthRecord(Model model) {			
	    return "addhealthrecord";
	}
	@RequestMapping(value = { "/nursevisit/addnursevisit"}, method = RequestMethod.GET)
	public String addNurseVisit(Model model) {
		List<Doctor> doctors=loginService.getdoctors();
		List<Nurse> nurses=loginService.getNurses();
		List<Patient> patients=loginService.getPatients();
		model.addAttribute("doctors", doctors);
		model.addAttribute("nurses", nurses);
		model.addAttribute("patients", patients);
	    return "addnursevisit"; 
	}
	@RequestMapping(value = { "/savehealthrecord"}, method = RequestMethod.POST)
	public String saveHealthRecord(Model model, HealthRecord healthRecord) {
		System.out.println(healthRecord);
		healthRecordService.save(healthRecord);
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords();
		model.addAttribute("healthRecords", healthRecords);		
	    return "viewhealthrecords";
	}
	@RequestMapping(value = { "/savenursevisit"}, method = RequestMethod.POST)
	public String savNurseVisit(Model model, PatientRelation patientRelation) {
		System.out.println(patientRelation);
		UUID uuid = UUID.randomUUID();
		HealthRecord healthRecord = new HealthRecord();
		healthRecord.setHealthId(uuid.getLeastSignificantBits());
		healthRecord.setMedicare("Care");
		healthRecord.setPatientId(patientRelation.getPatientId());
		healthRecord.setDoctorId(patientRelation.getDoctorId());
		healthRecord.setNurseId(patientRelation.getNurseId());
		if(HEALTH_COUNT%2==0) {			
			healthRecord.setHealthInfo("Good");
			healthRecord.setHealthSummary("Fine");
			healthRecord.setAge(30);
			healthRecord.setClaims("No Claims");
			healthRecord.setEmergencyContact(345345435);
		}else {
			healthRecord.setHealthInfo("Average");
			healthRecord.setHealthSummary("Good");
			healthRecord.setAge(40);
			healthRecord.setClaims("One Claim");
			healthRecord.setEmergencyContact(5454545);
		}
		healthRecordService.save(healthRecord);
		HEALTH_COUNT++;
		patientRelation.setNurseVisitingDate(new Date());
		patientService.save(patientRelation);
		List<PatientRelation> patientRelations=patientService.getPatientRelations();	
		model.addAttribute("patientRelations", patientRelations);
	    return "nursevisiting";
	}
	@RequestMapping(value="/deletehealthrecord/{id}",method=RequestMethod.GET)
	String delete(@PathVariable("id") int id,Model model)throws Exception{		
		healthRecordService.delete(id);
		List<HealthRecord>  healthRecords= healthRecordService.getHealthRecords();
		model.addAttribute("healthRecords", healthRecords);		
	    return "viewhealthrecords";
	}
	@RequestMapping(value="/deletenursevisit/{id}",method=RequestMethod.GET)
	String deleteNurseVisit(@PathVariable("id") int id,Model model)throws Exception{
		patientService.delete(id);
		List<PatientRelation> patientRelations=patientService.getPatientRelations();	
		model.addAttribute("patientRelations", patientRelations);
	    return "nursevisiting";
	}
	@RequestMapping(value = { "/register"}, method = RequestMethod.GET)
	public String register(Model model) {			
	    return "register";
	}
	@RequestMapping(value = { "/savepatient"}, method = RequestMethod.POST)
	public String saveHealthRecord(Model model, Patient patient) {
		System.out.println(patient);
		patientService.save(patient);			
	    return "login";
	}
}
