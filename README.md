<p align="center">
<picture>
  <source srcset="/press_kit/title.png">
  <img alt="Prism Launcher" src="/press_kit/title.png" width="40%">
</picture>
</p>

## Forking/Redistributing/Custom builds policy

You are free to fork, redistribute and provide custom builds as long as you follow the terms of the [license](LICENSE) (this is a legal responsibility), and if you made code changes rather than just packaging a custom build, please do the following as a basic courtesy:

- Make it clear that your fork is not Prism Launcher and is not endorsed by or affiliated with the Prism Launcher project (<https://prismlauncher.org>).
- Go through [CalciumAuth.java](src/main/java/com/ruinedmango/CalciumLauncher/CalciumAuth.java) and change Prism Launcher's API keys to your own or set them to empty strings (`""`) to disable them (this way the program will still compile but the functionality requiring those keys will be disabled).

If you have any questions or want any clarification on the above conditions please make an issue and ask us.

Note that if you build this software without removing the provided API keys in [CalciumAuth.java](src/main/java/com/ruinedmango/CalciumLauncher/CalciumAuth.java) you are accepting the following terms and conditions:

- [Microsoft Identity Platform Terms of Use](https://docs.microsoft.com/en-us/legal/microsoft-identity-platform/terms-of-use)

If you do not agree with these terms and conditions, then remove the associated API keys from the [CalciumAuth.java](src/main/java/com/ruinedmango/CalciumLauncher/CalciumAuth.java) file by setting them to an empty string (`""`).


## License ![GitHub License](https://img.shields.io/github/license/RuinedMango/CalciumLauncher)
All launcher code is available under the EPL-2.0 license.

The logo and related assets are under the CC BY-SA 4.0 license.
