![cryptomator-android](cryptomator-android.png)


Cryptomator offers multi-platform transparent client-side encryption of your files in the cloud.

Cryptomator for Android is currently available in the following  distribution channels:

1. Building from source using Gradle (instructions below)

## Building

### Dependencies

* Git
* JDK 11
* Gradle

### Run Git and Gradle

```
git submodule init && git submodule update // (not necessary if cloned using --recurse-submodules)
./gradlew assembleApkstoreDebug
```

Before connecting to Dropbox, OneDrive or pCloud you have to provide valid API keys using environment variables:
For build type

* **release**: `DROPBOX_API_KEY`, `ONEDRIVE_API_KEY` and  `ONEDRIVE_API_REDIRCT_URI` or `PCLOUD_CLIENT_ID`
* **debug**: `DROPBOX_API_KEY_DEBUG`, `ONEDRIVE_API_KEY_DEBUG` and `ONEDRIVE_API_REDIRCT_URI_DEBUG` or `PCLOUD_CLIENT_ID_DEBUG`

Before connecting to Google Drive you have to create a new project in [Google Cloud Platform](https://console.cloud.google.com) with Google Drive API, credentials including Google Drive scopes (read, write, delete,..) and the fingerprint of the key you use to build the app.

### Reproducible Build Cryptomator Lite

Use the Docker image to verify the build of the 'lite' flavor:

1. Clone this repository (don't forget `--recurse-submodules`)
2. Checkout the tag you want to build, e.g. 1.8.0
3. Build the image using `docker build -t cryptomator-android .` in the `buildsystem/` directory
4. Build Cryptomator using `docker run --rm -u $(id -u):$(id -g) -v $(pwd):/project -w /project cryptomator-android ./gradlew clean assembleLiteRelease` in the root of this folder
5. Compare the build APK with the release version, using e.g. `apksigcopier compare --unsigned apk1 apk2`

## Contributing to Cryptomator for Android

Please read our [contribution guide](.github/CONTRIBUTING.md), if you would like to report a bug, ask a question, translate the app or help us with coding.

Please make sure before creating a PR, to apply the code style by executing reformat code with optimize imports and rearrange code enabled. The best way to do this is to create a macro for it in android studio and set it to the save shortcut.

## Code of Conduct

Help us keep Cryptomator open and inclusive. Please read and follow our [Code of Conduct](.github/CODE_OF_CONDUCT.md).

## License

This project is dual-licensed under the GPLv3 for FOSS projects as well as a commercial license for independent software vendors and resellers. If you want to modify this application under different conditions, feel free to contact our support team.
