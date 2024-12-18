package com.ruinedmango.CalciumLauncher;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;
import org.rauschig.jarchivelib.CompressionType;
import org.to2mbn.jmccc.option.JavaEnvironment;

import com.github.tnakamot.os.Detector;

public class JRE {
	private String JRE_BASE_PATH = System.getProperty("user.home") + "/.calcium/jres/";
	private String javaVer;
	private String os;
	private String arch;
	
	public JavaEnvironment findJavaEnviroment(String version) {
		if(!new File(JRE_BASE_PATH).exists()) {
			new File(JRE_BASE_PATH).mkdirs();
		}
		if(!SystemUtils.IS_OS_WINDOWS) {
			if(!new File(JRE_BASE_PATH + "JRE8/").exists()) {
				switch(Detector.getNormalizedOSName()) {
					case "osx":
						os = "mac";
					case "sunos":
						os = "solaris";
					default:
						os = Detector.getNormalizedOSName();
				}
				switch(Detector.getNormalizedArchitectureName()) {
					case "x86_32":
						arch = "x86";
					case "x86_64":
						arch = "x64";
					case "ppc_64":
						arch = "ppc64";
					case "ppcle_64":
						arch = "ppc64le";
					case "s390_64":
						arch = "s390x";
					case "aarch_64":
						arch = "aarch64";
					case "arm_32":
						arch = "arm";
					case "sparc_64":
						arch = "sparcv9";
					default:
						arch = Detector.getNormalizedArchitectureName();
				}
				try {
					FileUtils.copyURLToFile(new URL("https://api.adoptium.net/v3/binary/latest/8/ga/" + os + "/" + arch + "/jre/hotspot/normal/eclipse"), new File(JRE_BASE_PATH + "JRE8.tar.gz"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
				try {
					archiver.extract(new File(JRE_BASE_PATH + "JRE8.tar.gz"), new File(JRE_BASE_PATH + "JRE8/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			if(!new File(JRE_BASE_PATH + "JRE8/").exists()) {
				switch(Detector.getNormalizedOSName()) {
					case "osx":
						os = "mac";
					case "sunos":
						os = "solaris";
					default:
						os = Detector.getNormalizedOSName();
				}
				switch(Detector.getNormalizedArchitectureName()) {
					case "x86_32":
						arch = "x86";
					case "x86_64":
						arch = "x64";
					case "ppc_64":
						arch = "ppc64";
					case "ppcle_64":
						arch = "ppc64le";
					case "s390_64":
						arch = "s390x";
					case "aarch_64":
						arch = "aarch64";
					case "arm_32":
						arch = "arm";
					case "sparc_64":
						arch = "sparcv9";
					default:
						arch = Detector.getNormalizedArchitectureName();
				}
				try {
					FileUtils.copyURLToFile(new URL("https://api.adoptium.net/v3/binary/latest/8/ga/" + os + "/" + arch + "/jre/hotspot/normal/eclipse"), new File(JRE_BASE_PATH + "JRE8.zip"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
				try {
					archiver.extract(new File(JRE_BASE_PATH + "JRE8.zip"), new File(JRE_BASE_PATH + "JRE8/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(!SystemUtils.IS_OS_WINDOWS) {
			if(!new File(JRE_BASE_PATH + "JRE16/").exists()) {
				switch(Detector.getNormalizedOSName()) {
					case "osx":
						os = "mac";
					case "sunos":
						os = "solaris";
					default:
						os = Detector.getNormalizedOSName();
				}
				switch(Detector.getNormalizedArchitectureName()) {
					case "x86_32":
						arch = "x86";
					case "x86_64":
						arch = "x64";
					case "ppc_64":
						arch = "ppc64";
					case "ppcle_64":
						arch = "ppc64le";
					case "s390_64":
						arch = "s390x";
					case "aarch_64":
						arch = "aarch64";
					case "arm_32":
						arch = "arm";
					case "sparc_64":
						arch = "sparcv9";
					default:
						arch = Detector.getNormalizedArchitectureName();
				}
				try {
					FileUtils.copyURLToFile(new URL("https://api.adoptium.net/v3/binary/latest/16/ga/" + os + "/" + arch + "/jdk/hotspot/normal/eclipse"), new File(JRE_BASE_PATH + "JRE16.tar.gz"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
				try {
					archiver.extract(new File(JRE_BASE_PATH + "JRE16.tar.gz"), new File(JRE_BASE_PATH + "JRE16/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			if(!new File(JRE_BASE_PATH + "JRE16/").exists()) {
				switch(Detector.getNormalizedOSName()) {
					case "osx":
						os = "mac";
					case "sunos":
						os = "solaris";
					default:
						os = Detector.getNormalizedOSName();
				}
				switch(Detector.getNormalizedArchitectureName()) {
					case "x86_32":
						arch = "x86";
					case "x86_64":
						arch = "x64";
					case "ppc_64":
						arch = "ppc64";
					case "ppcle_64":
						arch = "ppc64le";
					case "s390_64":
						arch = "s390x";
					case "aarch_64":
						arch = "aarch64";
					case "arm_32":
						arch = "arm";
					case "sparc_64":
						arch = "sparcv9";
					default:
						arch = Detector.getNormalizedArchitectureName();
				}
				try {
					FileUtils.copyURLToFile(new URL("https://api.adoptium.net/v3/binary/latest/16/ga/" + os + "/" + arch + "/jdk/hotspot/normal/eclipse"), new File(JRE_BASE_PATH + "JRE16.zip"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
				try {
					archiver.extract(new File(JRE_BASE_PATH + "JRE16.zip"), new File(JRE_BASE_PATH + "JRE16/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(!SystemUtils.IS_OS_WINDOWS) {
			if(!new File(JRE_BASE_PATH + "JRE17/").exists()) {
				switch(Detector.getNormalizedOSName()) {
					case "osx":
						os = "mac";
					case "sunos":
						os = "solaris";
					default:
						os = Detector.getNormalizedOSName();
				}
				switch(Detector.getNormalizedArchitectureName()) {
					case "x86_32":
						arch = "x86";
					case "x86_64":
						arch = "x64";
					case "ppc_64":
						arch = "ppc64";
					case "ppcle_64":
						arch = "ppc64le";
					case "s390_64":
						arch = "s390x";
					case "aarch_64":
						arch = "aarch64";
					case "arm_32":
						arch = "arm";
					case "sparc_64":
						arch = "sparcv9";
					default:
						arch = Detector.getNormalizedArchitectureName();
				}
				try {
					FileUtils.copyURLToFile(new URL("https://api.adoptium.net/v3/binary/latest/17/ga/" + os + "/" + arch + "/jre/hotspot/normal/eclipse"), new File(JRE_BASE_PATH + "JRE17.tar.gz"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
				try {
					archiver.extract(new File(JRE_BASE_PATH + "JRE17.tar.gz"), new File(JRE_BASE_PATH + "JRE17/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			if(!new File(JRE_BASE_PATH + "JRE17/").exists()) {
				switch(Detector.getNormalizedOSName()) {
					case "osx":
						os = "mac";
					case "sunos":
						os = "solaris";
					default:
						os = Detector.getNormalizedOSName();
				}
				switch(Detector.getNormalizedArchitectureName()) {
					case "x86_32":
						arch = "x86";
					case "x86_64":
						arch = "x64";
					case "ppc_64":
						arch = "ppc64";
					case "ppcle_64":
						arch = "ppc64le";
					case "s390_64":
						arch = "s390x";
					case "aarch_64":
						arch = "aarch64";
					case "arm_32":
						arch = "arm";
					case "sparc_64":
						arch = "sparcv9";
					default:
						arch = Detector.getNormalizedArchitectureName();
				}
				try {
					FileUtils.copyURLToFile(new URL("https://api.adoptium.net/v3/binary/latest/17/ga/" + os + "/" + arch + "/jre/hotspot/normal/eclipse"), new File(JRE_BASE_PATH + "JRE17.zip"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
				try {
					archiver.extract(new File(JRE_BASE_PATH + "JRE17.zip"), new File(JRE_BASE_PATH + "JRE17/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Float realver = Float.parseFloat(StringUtils.substringBeforeLast(version, "."));
		if(StringUtils.substringBeforeLast(version, ".").length() == 3) {
			realver -= 1;
			realver /= 10;
			realver += 1;
		}
		if(realver < 1.17){
			javaVer = "8";
		} else if(realver >= 1.17 && Float.parseFloat(StringUtils.substringBeforeLast(version, ".")) < 1.18){
			javaVer = "16";
		} else if(realver >= 1.18){
			javaVer = "17";
		}
		File innerJRE = new File(JRE_BASE_PATH + "JRE" + javaVer + "/").listFiles()[0];
		System.out.print(JRE_BASE_PATH + "JRE" + javaVer + "/" + innerJRE.getName() + "/bin/java" );
		return new JavaEnvironment(new File(JRE_BASE_PATH + "JRE" + javaVer + "/" + innerJRE.getName() + "/bin/java" ));
	}
}
