/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDDocument")
@ViewScoped
public class ADDocument implements Serializable {

    private UploadedFile file;
    private String currentUrl = "";

    /**
     * Creates a new instance of ADDocument
     */
    public String upload() {
        if (file == null) {
            System.out.println("Por favor, selecciona un archivo.");
            return "Error: No se seleccionó ningún archivo.";
        }

        try {
            System.out.println("Archivo recibido: " + file.getFileName());

            // Ruta física para guardar el archivo
            String absoluteDiskPath = FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRealPath("/resources/pdf/");
            File destinationFolder = new File(absoluteDiskPath);

            if (!destinationFolder.exists() && !destinationFolder.mkdirs()) {
                System.err.println("No se pudo crear la carpeta: " + absoluteDiskPath);
                return "Error: No se pudo crear la carpeta de destino.";
            }

            // Guardar el archivo
            String fileName = file.getFileName();
            File destinationFile = new File(destinationFolder, fileName);
            try (InputStream input = file.getInputStream(); FileOutputStream output = new FileOutputStream(destinationFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }

            // Generar URL del archivo
            currentUrl = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
                    + "/resources/pdf/" + fileName + "?v=" + System.currentTimeMillis();

            System.out.println("Archivo guardado exitosamente en: " + destinationFile.getAbsolutePath());
            System.out.println("URL generada: " + currentUrl);

            return "Archivo subido correctamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar el archivo.";
        }
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    public ADDocument() {
    }

}
