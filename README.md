# ScreenCast Extension for MIT App Inventor

**ScreenCast** is an extension designed exclusively for screen mirroring and related settings on Android devices. This extension was inspired by a question in the [MIT App Inventor Community](https://community.appinventor.mit.edu/t/hi-i-needed-help-in-screen-cast/120962/3) and simplifies the process of integrating screen casting features into your apps.

With **ScreenCast**, you can:
- Open the system's screen mirroring settings.
- Stop active screen mirroring sessions by navigating to the appropriate settings.
- Enable or disable logging for debugging purposes.

---

## Features

1. **Open Screen Mirroring Settings**: Directly navigate to Android's screen casting configuration page.
2. **Stop Screen Mirroring**: Provide access to halt active screen casting sessions.
3. **Logging**: Activate or deactivate logs to debug your application effectively.

---

## Installation Guide

### Steps to Add the Extension

1. **Download the Extension**: Obtain the `ScreenCast.aix` file from the [Releases](#) section.
2. **Import into MIT App Inventor**:
   - Go to **Extensions** > **Import Extension** > **Upload File**.
   - Select the `ScreenCast.aix` file.
3. **Add the Component**:
   - Drag the `ScreenCast` component from the **Palette** into your workspace.

---

## How to Use

### Available Blocks

1. **SetLogging**
   - Enables or disables logging in the app.
   - Syntax:
     ```plaintext
     SetLogging(enable: Boolean)
     ```
     Example: 
     - Pass `true` to enable logs or `false` to disable them.

2. **OpenScreenMirroringSettings**
   - Opens the screen mirroring settings on the Android device.
   - Syntax:
     ```plaintext
     OpenScreenMirroringSettings()
     ```

3. **StopScreenMirroring**
   - Navigates to the settings page where users can stop screen mirroring.
   - Syntax:
     ```plaintext
     StopScreenMirroring()
     ```

### Example Usage in MIT App Inventor

1. Add two buttons:
   - Label one as **"Start Mirroring"** and another as **"Stop Mirroring"**.
2. Connect these buttons to the respective blocks:
   - Use `OpenScreenMirroringSettings` for the start button.
   - Use `StopScreenMirroring` for the stop button.

Here’s an example block setup:

```plaintext
When Button1.Click
    call ScreenCast.OpenScreenMirroringSettings

When Button2.Click
    call ScreenCast.StopScreenMirroring
```

---

## Using Native ActivityStarter for Screen Mirroring

If you prefer to use the native **ActivityStarter** component, follow these steps:

1. **Add the ActivityStarter Component**:
   - Drag it from the **Palette** into your workspace.
2. **Configure the Properties**:
   - Set the **Action** to:
     - `"android.settings.CAST_SETTINGS"` or 
     - `"android.settings.WIFI_DISPLAY_SETTINGS"` (for older devices).
3. **Trigger the Action**:
   - Use a button click to call `ActivityStarter.StartActivity`.

### Example Blocks for ActivityStarter

```plaintext
When Button1.Click
    set ActivityStarter1.Action to "android.settings.CAST_SETTINGS"
    call ActivityStarter1.StartActivity
```

---

## Permissions Required

The extension automatically handles required permissions, but for reference, these include:

```xml
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

---

## Screenshots

*(Add screenshots of the blocks or a demo app interface.)*

---

## Community Support

This extension is inspired by a question raised in the [MIT App Inventor Community](https://community.appinventor.mit.edu/t/hi-i-needed-help-in-screen-cast/120962/3). If you have additional queries or suggestions, please visit the community or open an issue in this repository.

---

## License

This project is licensed under the [MIT License](LICENSE).
