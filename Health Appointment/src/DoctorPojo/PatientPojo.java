package DoctorPojo;

public class PatientPojo {
	public static int pid;
	public	static String pname,pcontact,pemail;
	public static int getPid() {
		return pid;
	}
	public static void setPid(int pid) {
		PatientPojo.pid = pid;
	}
	public static String getPname() {
		return pname;
	}
	public static void setPname(String pname) {
		PatientPojo.pname = pname;
	}
	public static String getPcontact() {
		return pcontact;
	}
	public static void setPcontact(String pcontact) {
		PatientPojo.pcontact = pcontact;
	}
	public static String getPemail() {
		return pemail;
	}
	public static void setPemail(String pemail) {
		PatientPojo.pemail = pemail;
	}
}
