# List View

> Se reutiliza la vista si es que no es null

```kotlin
override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(resourceId, parent, false)
        view.tvTitle.text = pollList[position].title
        view.tvBody.text = pollList[position].body
        return view
}
```

> Se infla una nueva vista en cada item

```kotlin
override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = inflater.inflate(resourceId, parent, false)
        view.tvTitle.text = pollList[position].title
        view.tvBody.text = pollList[position].body
        return view
}
```

*En el ejemplo no se usa la librería Gson de google para parsear los datos.*
