import os

carpeta = "/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Proceso/Images"

# Lista todos los archivos en la carpeta
imagenes = os.listdir(carpeta)

# Recorre la lista de archivos y renómbralos
f = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Proceso/super_smash_bross.txt","a")
for imagen in imagenes:
    f.write(imagen+"\n")
f.close()