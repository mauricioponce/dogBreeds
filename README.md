# Dog Breeds

Listado de las razas de perros desde la API de [dog.ceo](https://dog.ceo/dog-api/documentation/)

Es una aplicación Android nativa escrita en Java utilizando la [Guía de arquitectura de apps](https://developer.android.com/jetpack/docs/guide?hl=es-419)

Utiliza un [SharedViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel#sharing) en el listing principal y en el listado de las imágenes para cada raza

Bibliotecas:
 * [Navigation](https://developer.android.com/guide/navigation) para moverse entre los fragments
 * [Glide](https://github.com/bumptech/glide) para cargar las imágenes
 * [Retrofit](https://square.github.io/retrofit/) para las llamadas a la API
 * [Timber](https://github.com/JakeWharton/timber) para logging
 * [truth](https://github.com/google/truth) para asserts
 * [jraska.livedata](https://github.com/jraska/livedata-testing) para testing de livedata
