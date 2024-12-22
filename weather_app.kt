package com.example.zadania_z_mobilnych_1

interface IWeather {
    val type: String
}

class Sunny : IWeather {
    override val type: String = "sunny"
}

class Cloudy : IWeather {
    override val type: String = "cloudy"
}

class Foggy : IWeather {
    override val type: String = "foggy"
}

class Rainy : IWeather {
    override val type: String = "rainy"
}

class Windy : IWeather {
    override val type: String = "windy"
}

class Stormy : IWeather {
    override val type: String = "stormy"
}

class Snowy : IWeather {
    override val type: String = "snowy"
}

data class CityWeather(val cityName: String, val weather: IWeather)

fun main() {
    val cityWeathers = listOf(
        CityWeather("Warsaw", Sunny()),
        CityWeather("Krakow", Cloudy()),
        CityWeather("Gdansk", Rainy()),
        CityWeather("Wroclaw", Windy()),
        CityWeather("Poznan", Foggy()),
        CityWeather("Lodz", Stormy()),
        CityWeather("Szczecin", Snowy()),
        CityWeather("Lublin", Sunny()),
        CityWeather("Katowice", Rainy()),
        CityWeather("Bialystok", Cloudy())
    )

    println("Select a city to view the weather forecast:")
    cityWeathers.forEachIndexed { index, cityWeather ->
        println("${index + 1}. ${cityWeather.cityName}")
    }

    val choice = readLine()?.toIntOrNull()
    if (choice != null && choice in 1..cityWeathers.size) {
        val selectedCityWeather = cityWeathers[choice - 1]
        println("City: ${selectedCityWeather.cityName}, Weather: ${selectedCityWeather.weather.type}")
    } else {
        println("Invalid choice. Please restart the program and try again.")
    }
}