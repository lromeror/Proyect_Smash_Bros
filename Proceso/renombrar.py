import os

# Especifica la ruta de la carpeta
carpeta = "/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Proceso/Images"

# Lista todos los archivos en la carpeta
archivos = os.listdir(carpeta)

# Recorre la lista de archivos y renómbralos
for archivo in archivos:
    # Construye la ruta completa del archivo
    ruta_completa = os.path.join(carpeta, archivo)
    
    # Define el nuevo nombre del archivo
    nuevo_nombre = archivo.split(".")[0] + ".png"
    
    # Construye la nueva ruta completa del archivo
    nueva_ruta = os.path.join(carpeta, nuevo_nombre)
    
    # Renombra el archivo
    os.rename(ruta_completa, nueva_ruta)

print("Archivos renombrados con éxito.")
