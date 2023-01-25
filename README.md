
[![](https://jitpack.io/v/kovacivan84/SplashScreenHelper.svg)](https://jitpack.io/#kovacivan84/SplashScreenHelper)


# SplashScreenHelper Android library

SplashScreenHelper is a lightweight, easy-to-use android library that will help you add a splash screen to your app. In a few easy steps, you can add your logo and some text and animate it. Or perhaps you want to add a video. SplashScreenHelper can do that also.

## Implementation
#### Gradle
In root build.gradle
```bash
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
In project build.gradle
```bash
implementation 'com.github.kovacivan84:SplashScreenHelper:1.1'
```
## Usage
#### Image and text underneath it:
```bash
SplashScreenHelper(this)
    .logoResource(R.drawable.your_logo)
    .setText("Some text here")
    .start()
```
#### If you want to add sub text underneath added text:
```bash
SplashScreenHelper(this)
    .logoResource(R.drawable.your_logo)
    .setText("Some text here")
    .setSubText("Some other text")
    .start()
```
#### If you want to add image instead of text:
```bash
SplashScreenHelper(this)
    .logoResource(R.drawable.your_logo)
    .bottomImageResource(R.drawable.some_image)
    .start()
```
#### You can set video as a splash screen
```bash
SplashScreenHelper(this)
    .videoResource(R.raw.some_video)
    .start()
```
#### All options
| Option      | Description |
| ----------- | ----------- |
|showLogo(boolean)      | Show or hide the logo       |
|logoResource(Int)   | Add your logo resource        |
|logoDimensions(width, height)|Change size of your logo|
|logoSpin(boolean)|Make your logo spin|
|showText(boolean)|Show or hide text under logo|
|setText(String)|Add your text|
|textColor(Int)|Change text color (eg. Color.RED)|
|textColorHex(String)|Change text color in HEX format (eg. "#FF0000)|
|textTypeface(Int)|Change text Typeface (eg. Typeface.BOLD)|
|textSize(Int)|Change text size|
|showSubText(boolean)|Show sub text under text|
|setSubText(String)|Set sub text|
|subTextColor(Int)|Change sub text color (eg. Color.RED)|
|subTextColorHex(String)|Change sub text color in HEX format (eg. "#FF0000)|
|subTextTypeface(Int)|Change sub text Typeface (eg. Typeface.BOLD)|
|subTextSize(Int)|Change sub text size|
|showBottomImage(boolean)|Show or hide image instead of text and sub text|
|bottomImageResource(Int)|Add your bottom image resource|
|bottomImageHeight(Int)|Change height of bottom image|
|backgroundColor(Int)|Add background color to whole splash screen (eg. Color.RED)|
|backgroundColorHex(String)|Add background color to whole splash screen in HEX format (eg. "#FF0000)|
|setBackgroundImageResource(Int)|Add image as background to whole splash screen|
|dividerHeight(Int)|Change space height between logo and text|
|textDividerHeight(Int)|Change space height between text and sub text|
|showProgressBar(boolean)|Show or hide progress bar|
|progressBarType(Int)|Choose progress bar type (eg. ProgressBarType.HORIZONTA)|
|progressBarPosition(Int)|Change position of progress bar (eg. ProgressBarPosition.INSTEAD_OF_TEXT)|
|progressBarColor(Int)|Change progress bar color (eg. Color.RED)|
|progressBarColorHex(String)|Change progress bar colo in HEX format (eg. "#FF0000)|
|delay(Long)|Set delay before animation start in milliseconds|
|duration(Long)|Set duration of animation in milliseconds|
|pause(Long)|Set pause after animation in milliseconds|
|animationType(AnimationType)|Choose animation type (eg.AnimationType.FLY_IN)|
|finishOnClick(boolean)|End splash screen on click|
|showVideo(boolean)|Show or hide video instead of logo, text and sub text|
|videoResource(Int)|Add your video resource|
|fitVideoToScreen(boolean)|Changes scale of video to fit in the screen|
|loopVideo(boolean)|Loops video indefinitely|
|fullscreen(boolean)|Show splash screen in fullscreen|
|start()|Starts splash screen|

#### ProgressBarType
| Type      | Description |
| ----------- | ----------- |
|CIRCULAR|Round progress bar|
|HORIZONTAL|Linear progress bar|

#### ProgressBarPosition
| Position      | Description |
| ----------- | ----------- |
|TOP|Top of the screen|
|BOTTOM|Bottom of the screen|
|UNDER_TEXT|Underneath the text|
|INSTEAD_OF_TEXT|Hides text and sub text and show progress bar|

#### AnimationType
| Position      | Description |
| ----------- | ----------- |
|FLY_IN|Logo flies in from the top and text and sub text flies in from the bottom|
|FLY_OUT|Logo flies out to the top and text and sub text flies out to the bottom|
|FADE_IN|Fades in|
|FADE_OUT|Fades out|


## Licence
Copyright Ivan Kovac

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
