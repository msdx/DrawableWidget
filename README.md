# DrawableWidget

[![Build Status](https://travis-ci.org/msdx/DrawableWidget.png)](https://travis-ci.org/msdx/DrawableWidget)
[ ![Download](https://api.bintray.com/packages/msdx/maven/drawablewidget/images/download.svg) ](https://bintray.com/msdx/maven/drawablewidget/_latestVersion)

The widgets that the drawable size could be custom in xml.

## Installation

Make sure you declare the JCenter repository in your project's `build.gradle`:

    repositories {
        jcenter()
    }

Then add a compile-time dependency on this library, adding the `dependencies` section to `build.gradle` if it doesn't already exist:

    dependencies {
        compile 'com.githang:drawable-widget:0.1.3'
    }

## Usage

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    xmlns:app="http://schemas.android.com/apk/res-auto"
                    android:layout_width="match_parent"
                    android:orientation="vertical"
                    android:layout_height="match_parent">

        <com.githang.drawablewidget.DrawableButton
            android:text="@string/with_drawable_size"
            android:drawableRight="@drawable/launcher"
            android:drawableEnd="@drawable/launcher"
            app:drawableWidth="32dp"
            app:drawableHeight="32dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
    </LinearLayout>
