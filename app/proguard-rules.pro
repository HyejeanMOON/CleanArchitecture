# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-----------------------------------------


# mappingファイルを生成する
-verbose
-printmapping proguardMapping.txt

#難読化する際、大文字小文字で混ぜない
-dontusemixedcaseclassnames

#Dalvikで潜在なリスクがある
-dontoptimize

-dontpreverify

-dontskipnonpubliclibraryclasses

-dontskipnonpubliclibraryclassmembers

#難読化のスピードが向上する為に
-dontpreverify

#reflect機能が正常的に使えるように
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod

-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*


#エラーが発生する際、エラーメッセージを出す
-keepattributes SourceFile,LineNumberTable


-keepclasseswithmembernames class * {
    native <methods>;
}


-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService


# activityのviewに関するメソッドは難読化しない、
# layout中のonClickに影響があるかもしれない。
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}


# 保留Serializable序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#RとRの関連クラスとメソッドが難読化されないようにする
-keep class **.R$* {
    *;
}

#jsのメソッドが難読化されないようにキープする
-keepclassmembers class com.example.xxx.MainActivity$JSInterface1 {
    <methods>;
}


