<p align="center">
<picture>
  <source srcset="/press_kit/title.png">
  <img alt="Prism Launcher" src="/press_kit/title.png" width="40%">
</picture>
</p>

## Mission Statement

Calcium Launcher is built as a place for anyone to publish a modpack no matter how wacky or ourageous it is. Though Calcium Launcher started as a place for me and a couple close friends to post wacky and stupid modpacks. It has turned into something more; a place where stupidity and outrageousness should florish. The core principal of Calcium Launcher is that anyone should be able to post whatever kind of modpack they want with no restrictions. Calcium Launcher is not just a mirror of the modpacks on sites such as CurseForge and Modrinth. Calcium Launcher is meant to be a small platform much like the old [Void's Wrath](https://voidswrath.com/) or the newer [Technic](https://www.technicpack.net/) launcher. Calcium Launcher doesn't promote quality and gameplay, Over all Calcium Launcher promotes creativity and fun.

## Features

- [x] All version support
- [x] Automatic management of JREs
- [x] Modloader support
  - [x] Forge
  - [x] Fabric
  - [x] Quilt
  - [ ] Neoforge(WIP)
  - [ ] Optifine Standalone(WIP)
- [x] Offline account
- [ ] Mojang Auth(Considering)
- [ ] Microsoft Auth(Waiting Approval)
- [x] Pack Management
  - [ ] Pack uploading(Upon request at ruinedmango@ruinedmango.com, webui WIP)        

## Technologies

Calcium Launcher is built upon JavaFX and my personal fork of JMCCC([Official](https://github.com/xfl03/JMCCC), [Personal](https://github.com/RuinedMango/Neofix)) which by extension is built upon Mojang's Minecraft. It is also of course built upon the best programming language, Java.

## Forking/Redistributing/Custom builds policy

You are free to fork, redistribute and provide custom builds as long as you follow the terms of the [license](LICENSE) (this is a legal responsibility), and if you made code changes rather than just packaging a custom build, please do the following as a basic courtesy:

- Make it clear that your fork is not Calcium Launcher and is not endorsed by or affiliated with the Calcium Launcher project (<https://prismlauncher.org>).
- Go through [CalciumAuth.java](src/main/java/com/ruinedmango/CalciumLauncher/CalciumAuth.java) and change Calcium Launcher's API keys to your own or set them to empty strings (`""`) to disable them (this way the program will still compile but the functionality requiring those keys will throw Exceptions).

If you have any questions or want any clarification on the above conditions please make an issue and ask us.

Note that if you build this software without removing the provided API keys in [CalciumAuth.java](src/main/java/com/ruinedmango/CalciumLauncher/CalciumAuth.java) you are accepting the following terms and conditions:

- [Microsoft Identity Platform Terms of Use](https://docs.microsoft.com/en-us/legal/microsoft-identity-platform/terms-of-use)

If you do not agree with these terms and conditions, then remove the associated API keys from the [CalciumAuth.java](src/main/java/com/ruinedmango/CalciumLauncher/CalciumAuth.java) file by setting them to an empty string (`""`).


## License ![GitHub License](https://img.shields.io/github/license/RuinedMango/CalciumLauncher)
All launcher code is available under the EPL-2.0 license.

The logo and related assets are under the CC BY-SA 4.0 license.
