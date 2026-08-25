-keep class com.dhikra.** { *; }
-keep class com.google.firebase.** { *; }
-keep class retrofit2.** { *; }
-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclasseswithmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
