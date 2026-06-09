# MCD
MCD CLI: calcula l'MCD con la tua app scritta a mano.
```
1.  addatta il codice dell'applicazione nel file ./MainActivity.java 
2.  gradle clean assembleDebug --- debug version
3.  gradle clean assembleRelease \
    -Pandroid.injected.signing.store.file=${HOME}/androidKeys/helloworld.jks \
    -Pandroid.injected.signing.store.password=$(<~/androidKeys/${USER}) \
    -Pandroid.injected.signing.key.alias=helloKey \
    -Pandroid.injected.signing.key.password=$(<~/androidKeys/${USER})   --- release finale
4.  esegui httpServer.sh per e carica l'eseguibile via Web sul telefonino.
