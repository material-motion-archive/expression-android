# Expression

This Expression library allows you to define your own Expression language.
See the sample/ application for an example of a custom Expression language.

### Depending on the library

Add it to your build.gradle with:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and:

```gradle
dependencies {
    compile 'com.github.material-motion:material-motion-expression-android:master-SNAPSHOT'
}
```

### Contributing to the library

Open Android Studio,
choose `File > New > Import`,
choose the root `build.gradle` file.

### Building the sample

Run `./gradlew installDebug` from the project root.
