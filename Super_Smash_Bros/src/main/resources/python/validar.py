import os 

carpeta = "/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/images_png_1"

# Lista todos los archivos en la carpeta
archivos = os.listdir(carpeta)

# Recorre la lista de archivos y renómbralos
f = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/archivos txt/fotos_png.txt","w")
for archivo in archivos:
    f.write(archivo+"\n")
f.close()

carpeta = "/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/videos_Smash_bros"

# Lista todos los archivos en la carpeta
archivos = os.listdir(carpeta)

# Recorre la lista de archivos y renómbralos
f = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/archivos txt/videos.txt","w")
for archivo in archivos:
    f.write(archivo+"\n")
f.close()

videos = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/archivos txt/videos.txt","r")
fotos = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/archivos txt/fotos_png.txt","r")
smash_p = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/smash.txt","r")
for u in range(3):  # numero de lineas que no sirven
    smash_p.readline()
videos_l = [x.strip("\n ").split('.')[0] for x in videos.readlines()]
fotos_l = [y.strip("\n").split('.')[0]for y in fotos.readlines()]
smash_p_l = [z.strip("\n").split(';')[1].lower().replace(" ","_").replace(".","") for z in smash_p.readlines()]
videos.close()
fotos.close()
smash_p.close()
validar = open("/Users/angelozurita/Repositorios_GitHub/Proyect_Smash_Bros/Super_Smash_Bros/src/main/resources/archivos txt/validar.txt","w")

foto_video_smah = []
validar.write("Hay video y fotos y correcto en smash.txt\n")
for video in videos_l:
    if (video in fotos_l) and (video in smash_p_l):
        validar.write(video+"\n")
        foto_video_smah.append(video)

validar.write("Hay video y fotos\n")
for video in videos_l:
    if (video in fotos_l) and (video not in foto_video_smah):
        validar.write(video+"\n")

validar.write("Solo hay video\n")
for video in videos_l:
    if video not in fotos_l:
        validar.write(video+"\n")

validar.write("Solo hay foto\n")
for foto in fotos_l:
    if foto not in videos_l:
        validar.write(foto+"\n")

validar.close()
