package com.ruinedmango.CalciumLauncher;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang3.StringUtils;
import org.to2mbn.jmccc.auth.AuthenticationException;
import org.to2mbn.jmccc.auth.Authenticator;
import org.to2mbn.jmccc.launch.LaunchException;
import org.to2mbn.jmccc.launch.Launcher;
import org.to2mbn.jmccc.launch.LauncherBuilder;
import org.to2mbn.jmccc.launch.MissingDependenciesException;
import org.to2mbn.jmccc.launch.ProcessListener;
import org.to2mbn.jmccc.mcdownloader.MinecraftDownloader;
import org.to2mbn.jmccc.mcdownloader.MinecraftDownloaderBuilder;
import org.to2mbn.jmccc.mcdownloader.download.concurrent.CallbackAdapter;
import org.to2mbn.jmccc.mcdownloader.provider.DownloadProviderChain;
import org.to2mbn.jmccc.mcdownloader.provider.fabric.FabricDownloadProvider;
import org.to2mbn.jmccc.mcdownloader.provider.forge.ForgeDownloadProvider;
import org.to2mbn.jmccc.mcdownloader.provider.liteloader.LiteloaderDownloadProvider;
import org.to2mbn.jmccc.option.JavaEnvironment;
import org.to2mbn.jmccc.option.LaunchOption;
import org.to2mbn.jmccc.option.MinecraftDirectory;
import org.to2mbn.jmccc.version.Library;
import org.to2mbn.jmccc.version.Version;
import org.to2mbn.jmccc.mcdownloader.provider.forge.ForgeVersionList;
import org.to2mbn.jmccc.mcdownloader.provider.liteloader.LiteloaderVersionList;
import org.to2mbn.jmccc.mcdownloader.provider.quilt.QuiltDownloadProvider;

public class Pack {
	public String name;
	public String loader;
	public String version;
	public String loaderVer;
	public String url;
	
	public Pack(String name, String loader, String version, String loaderVer, String url) {
		this.name = name;
		this.loader = loader;
		this.version = version;
		this.loaderVer = loaderVer;
		this.url = url;
	}

	public void install() throws InterruptedException, ExecutionException {
		MinecraftDirectory dir = new MinecraftDirectory(System.getProperty("user.home") + "/.calcium/packs/" + name);
		ForgeDownloadProvider forgeProvider = new ForgeDownloadProvider();
		LiteloaderDownloadProvider liteloaderProvider = new LiteloaderDownloadProvider();
		FabricDownloadProvider fabricProvider = new FabricDownloadProvider();
		QuiltDownloadProvider quiltProvider = new QuiltDownloadProvider();
		MinecraftDownloader downloader = MinecraftDownloaderBuilder.create()
			.providerChain(DownloadProviderChain.create()
				.addProvider(forgeProvider)
				.addProvider(liteloaderProvider)
				.addProvider(fabricProvider)
				.addProvider(quiltProvider))
			.build();
		downloader.download(forgeProvider.forgeVersionList(), new CallbackAdapter<ForgeVersionList>() {}).get();
		downloader.download(liteloaderProvider.liteloaderVersionList(), new CallbackAdapter<LiteloaderVersionList>() {}).get();
		switch(loader) {
			case "vanilla":
				System.out.print("Came from vanilla\n");
				downloader.downloadIncrementally(dir, version, new CallbackAdapter<Version>() {
					@Override
					public void done(Version ver) {
						System.out.print("Doned");
					}
					@Override
					public void failed(Throwable e) {
						System.out.print(e);
					}
				});
				break;
			case "forge":	
				System.out.print("Came from forge\n");
				downloader.downloadIncrementally(dir, version + "-forge" + version + "-" + loaderVer, new CallbackAdapter<Version>() {
					@Override
					public void done(Version ver) {
						System.out.print("Doned\n");
					}
					@Override
					public void failed(Throwable e) {
						System.out.print(e + "\n");
						downloader.downloadIncrementally(dir, version + "-forge" + version + "-" + loaderVer, new CallbackAdapter<Version>() {
							@Override
							public void done(Version ver) {
								System.out.print("Doned\n");
							}
							@Override
							public void failed(Throwable e) {
								System.out.print(e + "\n");
							}
						});
					}
				});
				break;
			case "liteloader":
				System.out.print("Came from liteloader\n");
				downloader.downloadIncrementally(dir, version + "-LiteLoader" + version, new CallbackAdapter<Version>() {
					@Override
					public void done(Version ver) {
						System.out.print("Doned");
					}
					@Override
					public void failed(Throwable e) {
						System.out.print(e);
					}
				});
				break;
			case "fabric":
				System.out.print("Came from fabric\n");
				downloader.downloadIncrementally(dir, "fabric-loader-" + loaderVer + "-" + version, new CallbackAdapter<Version>() {
					@Override
					public void done(Version ver) {
						System.out.print("Doned\n");
					}
					@Override
					public void failed(Throwable e) {
						System.out.print(e + "\n");
						downloader.downloadIncrementally(dir, "fabric-loader-" + loaderVer + "-" + version, new CallbackAdapter<Version>() {
							@Override
							public void done(Version ver) {
								System.out.print("Doned\n");
							}
							@Override
							public void failed(Throwable e) {
								System.out.print(e + "\n");
							}
						});
					}
				});
				break;
			case "quilt":
				System.out.print("Came from quilt\n");
				downloader.downloadIncrementally(dir, "quilt-loader-" + loaderVer + "-" + version, new CallbackAdapter<Version>() {
					@Override
					public void done(Version ver) {
						System.out.print("Doned");
					}
					@Override
					public void failed(Throwable e) {
						System.out.print(e);
					}
				});
				break;
		}
	}

	public void run(Authenticator auth) throws AuthenticationException, LaunchException, IOException {
		ProcessListener listener =  new CalciumListener();
		JavaEnvironment env = new JRE().findJavaEnviroment(version);
		MinecraftDirectory dir = new MinecraftDirectory(System.getProperty("user.home") + "/.calcium/packs/" + name);
		Launcher launcher = LauncherBuilder.create().printDebugCommandline(true).build();
		MinecraftDownloader downloader = MinecraftDownloaderBuilder.buildDefault();
		switch(loader) {
			case "vanilla":
				System.out.print("launching vanilla\n");
				try {
		            LaunchOption opt = new LaunchOption(version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
				} catch (MissingDependenciesException e) {
		            for (Library lib : e.getMissingLibraries()) {
		            	System.out.print("getting lib:" + lib.getArtifactId() + "\n");
		            	downloader.download(downloader.getProvider().library(dir, lib), new CallbackAdapter<Void>() {});
		            }
		            LaunchOption opt = new LaunchOption(version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
		        }
				break;
			case "forge":
				System.out.print("launching forge\n");
				Float realver = Float.parseFloat(StringUtils.substringBeforeLast(version, "."));
				if(StringUtils.substringBeforeLast(version, ".").length() == 3) {
					realver -= 1;
					realver /= 10;
					realver += 1;
				}
				if(realver < 1.12){
					try {
			            LaunchOption opt = new LaunchOption(version + "-Forge" + loaderVer + "-" + version, auth, dir);
			            opt.setJavaEnvironment(env);
			            launcher.launch(opt, listener);
					} catch (MissingDependenciesException e) {
			            for (Library lib : e.getMissingLibraries()) {
			            	System.out.print("getting lib:" + lib.getArtifactId() + "\n");
			            	downloader.download(downloader.getProvider().library(dir, lib), new CallbackAdapter<Void>() {});
			            }
			            LaunchOption opt = new LaunchOption(version + "-Forge" + loaderVer + "-" + version, auth, dir);
			            opt.setJavaEnvironment(env);
			            launcher.launch(opt, listener);
			        }
				} else {
					try {
			            LaunchOption opt = new LaunchOption(version + "-forge-" + loaderVer, auth, dir);
			            opt.setJavaEnvironment(env);
			            launcher.launch(opt, listener);
					} catch (MissingDependenciesException e) {
			            for (Library lib : e.getMissingLibraries()) {
			            	System.out.print("getting lib:" + lib.getArtifactId() + "\n");
			            	downloader.download(downloader.getProvider().library(dir, lib), new CallbackAdapter<Void>() {});
			            }
			            LaunchOption opt = new LaunchOption(version + "-forge-" + loaderVer, auth, dir);
			            opt.setJavaEnvironment(env);
			            launcher.launch(opt, listener);
			        }
				}
				break;
			case "liteloader":
				System.out.print("launching liteloader\n");
				try {
		            LaunchOption opt = new LaunchOption(version + "-LiteLoader" + version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
				} catch (MissingDependenciesException e) {
		            for (Library lib : e.getMissingLibraries()) {
		            	System.out.print("getting lib:" + lib.getArtifactId() + "\n");
		            	downloader.download(downloader.getProvider().library(dir, lib), new CallbackAdapter<Void>() {});
		            }
		            LaunchOption opt = new LaunchOption(version + "-LiteLoader" + version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
		        }
				break;
			case "fabric":
				System.out.print("launching fabric\n");
				try {
		            LaunchOption opt = new LaunchOption("fabric-loader-" + loaderVer + "-" + version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
				} catch (MissingDependenciesException e) {
		            for (Library lib : e.getMissingLibraries()) {
		            	System.out.print("getting lib:" + lib.getArtifactId() + "\n");
		            	downloader.download(downloader.getProvider().library(dir, lib), new CallbackAdapter<Void>() {});
		            }
		            LaunchOption opt = new LaunchOption("fabric-loader-" + loaderVer + "-" + version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
		        }
				break;
			case "quilt":
				System.out.print("launching quilt\n");
				try {
		            LaunchOption opt = new LaunchOption("quilt-loader-" + loaderVer + "-" + version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
				} catch (MissingDependenciesException e) {
		            for (Library lib : e.getMissingLibraries()) {
		            	System.out.print("getting lib:" + lib.getArtifactId() + "\n");
		            	downloader.download(downloader.getProvider().library(dir, lib), new CallbackAdapter<Void>() {});
		            }
		            LaunchOption opt = new LaunchOption("quilt-loader-" + loaderVer + "-" + version, auth, dir);
		            opt.setJavaEnvironment(env);
		            launcher.launch(opt, listener);
		        }
				break;
		}
	}
}