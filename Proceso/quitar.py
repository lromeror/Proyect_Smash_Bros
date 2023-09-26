from rembg import remove 
from PIL import Image
import os 

# Especifica la ruta de la carpeta
carpeta = "/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Proceso/images_png_1"

# Lista todos los archivos en la carpeta
imagenes = os.listdir(carpeta)

# Recorre la lista de archivos y renómbralos
for imagen in imagenes:
    # Construye la ruta completa del archivo de imagen
    ruta_completa = os.path.join(carpeta, imagen)
    
    try:
        # Abre la imagen usando la ruta completa
        img = Image.open(ruta_completa)
        
        # Elimina el fondo de la imagen
        oImg = remove(img)
        
        # Guarda la imagen modificada en la misma ubicación, sobrescribiendo la original
        oImg.save(ruta_completa, 'PNG')
    except Exception as e:
        print(f"Error procesando la imagen {imagen}: {e}")
        continue

print("Fondo eliminado de las imagenes")
