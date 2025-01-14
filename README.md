# TP FINAL HADOOP: Recommandation d'amis/de relations sur les réseaux sociaux
## Introduction


Voici une version révisée et reformulée de ton texte :

Dans ce TP, nous allons concevoir et implémenter une fonctionnalité phare des réseaux sociaux modernes : le système de recommandation d'amis ou de relations. Présente sur des plateformes telles que Facebook, LinkedIn ou Twitter, cette fonctionnalité propose aux utilisateurs des profils avec lesquels ils pourraient établir des affinités ou créer de nouvelles connexions. L’objectif de ce projet est de recréer ce mécanisme complexe en appliquant les principes du traitement de données massives et du filtrage collaboratif.

## Installation

1. Cloner le repos
2. Build l'image docker présente dans le fichier deploy : `docker build -t hadoop-tp3-img .`
3. Lancer le container docker : `docker run --rm -p 8088:8088 -p 9870:9870-p 9864:9864 -v $(pwd)/data:/data -v $(pwd)/jars:/jars hadoop-tp3-img `
4. Se connecter au container : `docker exec -it hadoop-tp3 bash`
5. Créer le dossier pour la data : `hdfs dfs -mkdir -p /user/gdemontureux/data`
6. Copier les fichiers de données dans le dossier input : `hdfs dfs -put /data/relationships/data.txt user/gdemontureux/data/`

### Job 1

1. `hadoop jar /jars/tpfinal-guilhem_demontureux_job1.jar org.epf.hadoop.colfil1.ColFilJob1 /user/gdemontureux/data/data.txt /user/gdemontureux/output`
2. `hdfs dfs -cat /user/gdemontureux/output/part-r-00000` pour afficher le résultat

Dans l'output, vous devriez voir les utilisateurs et leurs relations.

### Job 2

1. `hadoop jar /jars/tpfinal-guilhem_demontureux_job2.jar org.epf.hadoop.colfil2.ColFilJob2 /user/gdemontureux/output/part-r-00000 /user/gdemontureux/output2`
2. `hdfs dfs -cat /user/gdemontureux/output2/part-r-00000` pour afficher le résultat

Dans l'output, vous devriez voir les pairs d'utilisateurs et le nombre de relations communes.

### Job 3

1. `hadoop jar /jars/tpfinal-guilhem_demontureux_job3.jar org.epf.hadoop.colfil3.ColFilJob3 /user/gdemontureux/output2/part-r-00000 /user/hvanheerden/output3`
2. `hdfs dfs -cat /user/gdemontureux/output3/part-r-00000` pour afficher le résultat

Dans l'output, vous devriez voir les recommendations pour chaque utilisateur.