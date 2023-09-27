import os

carpeta = "/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/images_png_1"

# Lista todos los archivos en la carpeta
archivos = os.listdir(carpeta)

# Recorre la lista de archivos y renómbralos
f = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/archivos txt/fotos_png.txt","w")
for archivo in archivos:
    f.write(archivo+"\n")
f.close()