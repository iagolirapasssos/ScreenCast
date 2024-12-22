package com.bosonshiggs.screencast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.widget.Toast;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;

import java.io.IOException;

/**
 * ScreenCast: Extensão para abrir configurações de espelhamento, gravação de tela e gerenciamento avançado.
 */
@DesignerComponent(
    version = 2,
    versionName = "2.0",
    description = "Extension for screen mirroring, screen recording, and advanced management.",
    iconName = "icon.png"
)
public class ScreenCast extends AndroidNonvisibleComponent {
    
    private final Context context;
    private boolean enableLogs = false; // Controle de logs
    private static final String TAG = "ScreenCast";

    /**
     * Construtor da extensão ScreenCast.
     *
     * @param container O container do componente.
     */
    public ScreenCast(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
        logInfo("ScreenCast initialized.");
    }

    /**
     * Ativa ou desativa os logs.
     */
    @SimpleFunction(description = "Enable or disable logging.")
    public void SetLogging(boolean enable) {
        this.enableLogs = enable;
        Toast.makeText(context, "Logging is now " + (enable ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show();
    }

    /**
     * Abre as configurações de espelhamento de tela do sistema.
     */
    @SimpleFunction(description = "Open screen mirroring settings.")
    public void OpenScreenMirroringSettings() {
        try {
            context.startActivity(new Intent("android.settings.WIFI_DISPLAY_SETTINGS"));
            logInfo("Opened screen mirroring settings.");
        } catch (Exception e1) {
            try {
                context.startActivity(new Intent("android.settings.CAST_SETTINGS"));
                logInfo("Opened cast settings.");
            } catch (Exception e2) {
                logError("Screen mirroring settings not supported.", e2);
                Toast.makeText(context, "Screen mirroring settings not supported on this device.", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
		 * Para o espelhamento de tela.
		 */
		/**
	 * Para o espelhamento de tela via configurações.
	 */
	@SimpleFunction(description = "Stop screen mirroring by opening the relevant settings.")
	public void StopScreenMirroring() {
		try {
		    // Tentativa de abrir as configurações de transmissão
		    Intent intent = new Intent("android.settings.CAST_SETTINGS");
		    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    context.startActivity(intent);
		    logInfo("Opened cast settings for user to stop screen mirroring.");
		    Toast.makeText(context, "Please stop screen mirroring manually from the settings.", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
		    logError("Failed to open cast settings.", e);
		    Toast.makeText(context, "Stopping screen mirroring is not directly supported on this device.", Toast.LENGTH_LONG).show();
		}
	}

    
    /**
     * Loga mensagens de informação, se os logs estiverem ativados.
     */
    private void logInfo(String message) {
        if (enableLogs) {
            Log.i(TAG, message);
        }
    }

    /**
     * Loga mensagens de erro, se os logs estiverem ativados.
     */
    private void logError(String message, Exception e) {
        if (enableLogs) {
            Log.e(TAG, message, e);
        }
    }
}

