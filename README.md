# App-Client-Serveur-multiThreads.
Cette application suit l'architecture client-serveur, ce qui signifie qu'elle permet aux clients d'accéder simultanément au serveur. Son objectif est de calculer le prix
toutes taxes comprises (TTC) pour les articles sélectionnés par les clients. Pour gérer ces connexions simultanées, le serveur lance un "clientHandler" (thread) spécifique 
pour chaque client. Ce clientHandler est responsable de traiter les demandes du client et de lui fournir les réponses appropriées. En résumé, cette application offre une 
plateforme de calcul du prix TTC pour les articles sélectionnés, en permettant à plusieurs clients de se connecter et d'être servis simultanément grâce à l'utilisation de 
threads et d'une architecture client-serveur.
