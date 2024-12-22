Aqui está um README revisado, incluindo explicações sobre como usar o **ActivityStarter** nativo do MIT App Inventor com `android.settings.CAST_SETTINGS`:

---

# ScreenCast Extension for MIT App Inventor

**ScreenCast** is an extension for **MIT App Inventor** that provides advanced control for screen mirroring, screen recording, and media projection settings on Android devices. It simplifies access to system settings for managing screen casting, while also offering functionality like logging for debugging purposes.

## Features

- **Open Screen Mirroring Settings**: Navigate to the Android screen mirroring settings.
- **Stop Screen Mirroring**: Provide access to halt screen mirroring from system configurations.
- **Enable Logging**: Debug your app with real-time logs for events.

## Installation Guide

1. **Download**: Obtain the `ScreenCast.aix` file from the [Releases](#) section.
2. **Import to MIT App Inventor**:
   - Go to **Extensions** > **Import Extension** > **Upload File**.
   - Select and import the `ScreenCast.aix` file.
3. **Add to Project**:
   - Drag the `ScreenCast` component from the **Palette** into your app’s workspace.

## How to Use the ScreenCast Extension

### Blocks Overview

1. **SetLogging**
   - Enables or disables logging.

   ```plaintext
   SetLogging(enable: Boolean)
   ```
   Example:
   - Pass `true` to enable logs or `false` to disable them.

2. **OpenScreenMirroringSettings**
   - Opens the screen mirroring settings.

   ```plaintext
   OpenScreenMirroringSettings()
   ```

3. **StopScreenMirroring**
   - Opens settings to stop screen mirroring.

   ```plaintext
   StopScreenMirroring()
   ```

### Sample Blocks

Here’s an example of how to use the extension in your project:

1. Add two buttons: **Start Mirroring** and **Stop Mirroring**.
2. Connect these buttons to the `OpenScreenMirroringSettings` and `StopScreenMirroring` blocks respectively.
3. Use the `SetLogging` block for debugging during development.

---

## Using Native ActivityStarter for Android Settings

If you prefer to use the native **ActivityStarter** component instead of the ScreenCast extension, follow these steps:

1. **Add ActivityStarter**:
   - Drag the **ActivityStarter** component into your project.

2. **Configure ActivityStarter Properties**:
   - Set the following properties:
     - **Action**: `android.settings.CAST_SETTINGS`
     - **ActivityPackage**: (leave empty)
     - **ActivityClass**: (leave empty)

3. **Open Cast Settings**:
   - Use a button or event to call the `StartActivity` block of the `ActivityStarter`.

### Example Blocks with ActivityStarter

Here’s how to configure and use **ActivityStarter**:

- **Button Setup**:
  - Add a button labeled **"Open Cast Settings"**.
  - Use the following blocks to configure the button's action:

    ```plaintext
    When Button1.Click
        set ActivityStarter1.Action to "android.settings.CAST_SETTINGS"
        call ActivityStarter1.StartActivity
    ```

### Notes
- The `android.settings.CAST_SETTINGS` action may not work on all devices, depending on the Android version or manufacturer customizations.
- If `android.settings.CAST_SETTINGS` doesn’t work, try using `android.settings.WIFI_DISPLAY_SETTINGS`.

---

## Permissions Required

To ensure full functionality, the following permissions are needed:

```xml
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

These are automatically handled if you use the extension but need to be considered for custom implementations.

---

## Example App Screenshot

*(Include a screenshot of the blocks or app interface using the ScreenCast extension or ActivityStarter.)*

---

## Support

If you encounter any issues or have questions, feel free to open a GitHub issue or contact the [BosonsHiggs Team](mailto:bosonshiggsteam@gmail.com).
