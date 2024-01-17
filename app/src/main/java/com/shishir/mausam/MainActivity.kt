package com.shishir.mausam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.airbnb.lottie.LottieAnimationView
import com.shishir.mausam.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Query
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.locks.Condition

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding by lazy {
            ActivityMainBinding.inflate(layoutInflater)
        }

        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchmausamData("Jhansi")
        var searchItem = mutableListOf("Bhandup","Mumbai","Visakhapatnam","Coimbatore","Delhi","Bangalore","Pune","Nagpur","Lucknow","Vadodara","Indore","Jalalpur","Bhopal","Kolkata","Kanpur","New Delhi","Faridabad","Rajkot","Ghaziabad","Chennai","Meerut","Agra","Jaipur","Jabalpur","Varanasi","Allahabad","Hyderabad","Noida","Howrah","Thane","Patiala","Chakan","Ahmedabad","Manipala","Mangalore","Panvel","Udupi","Rishikesh","Gurgaon","Mathura","Shahjahanpur","Bagpat","Sriperumbudur","Chandigarh","Ludhiana","Palakkad","Kalyan","Valsad","Ulhasnagar","Bhiwani","Shimla","Dehradun","Patna","Unnao","Tiruvallur","Kanchipuram","Jamshedpur","Gwalior","Karur","Erode","Gorakhpur","Ooty","Haldwani","Bikaner","Puducherry","Nalbari","Bellary","Vellore","Naraina","Mandi","Rupnagar","Jodhpur","Roorkee","Aligarh","Indraprast","Karnal","Tanda","Amritsar","Raipur","Pilani","Bilaspur","Srinagar","Guntur","Kakinada","Warangal","Tirumala - Tirupati","Nizamabad","Kadapa","Kuppam","Anantpur","Nalgonda","Potti","Nellore","Rajahmundry","Bagalkot","Kurnool","Secunderabad","Mahatma","Bharuch","Miraj","Nanded","Anand","Gandhinagar","Bhavnagar","Morvi","Aurangabad","Modasa","Patan","Solapur","Kolhapur","Junagadh","Akola","Bhuj","Karad","Jalgaon Jamod","Chandrapur","Maharaj","Dhule","Ponda","Dahod","Navsari","Panjim","Patel","Nashik","Amravati","Somnath","Ganpat","Karwar","Davangere","Raichur","Nagara","Kushalnagar","Hassan","Hubli","Bidar","Belgaum","Mysore","Dharwad","Kolar","TumkÅ«r","Tiruchi","Thiruvananthapuram","Kozhikode","Thrissur","Madurai","Thalassery","Kannur","Karaikudi","Thanjavur","Manor","Idukki","Thiruvarur","Alappuzha","Gandhigram","Kochi","Annamalainagar","Amet","Kottarakara","Kottayam","Tirunelveli","Mohan","Salem","Attingal","Chitra","Chengannur","Guwahati","Kalam","Ranchi","Shillong","Gangtok","Srikakulam","Tezpur","Bhubaneswar","Imphal","Sundargarh","Arunachal","Manipur","Bihar Sharif","Mandal","Dibrugarh","Darbhanga","Gaya","Bhagalpur","Kunwar","Barddhaman","Jadabpur","Kalyani","Cuttack","Barpeta","Jorhat","Kharagpur","Medinipur","Agartala","Saranga","Machilipatnam","Dhanbad","Silchar","Dumka","Kokrajhar","Bankura","Jalpaiguri","Durgapur","Kalinga","Palampur","Jammu","Dwarka","Faridkot","Udaipur","Raigarh","Hisar","Solan","Ajmer","Lala","Gurdaspur","Sultanpur","Jhansi","Vidisha","Jagdalpur","Dipas","Sawi","Etawah","Saharanpur","Ujjain","Kangra","Bhilai","Rohtak","Haryana","Ambala","Bareilly","Bhoj","Kapurthala Town","Sangrur","Pusa","Sagar","Rewa","Bhawan","Rampur","Bhadohi","Cuddalore","Khopoli","Bali","Bhiwandi","Vasai","Badlapur","Sambalpur","Raurkela","Brahmapur","Visnagar","Surendranagar","Ankleshwar","Dahanu","Silvassa","Jamnagar","Dhansura","Muzaffarpur","Wardha","Bodhan","Parappanangadi","Malappuram","Vizianagaram","Mavelikara","Pathanamthitta","Satara","Janjgir","Gold","Himatnagar","Bodinayakkanur","Gandhidham","Mahabalipuram","Nadiad","Virar","Bahadurgarh","Kaithal","Siliguri","Tiruppur","Ernakulam","Jalandhar","Barakpur","Kavaratti","Ratnagiri","Moga","Hansi","Sonipat","Bandra","Aizawl","Itanagar","Nagar","Ghatkopar","Chen","Powai","Bhimavaram","Bhongir","Medak","Karimnagar","Narsapur","Vijayawada","Markapur","Mancherial","Sangli","Moradabad","Alipur","Ichalkaranji","Devgarh","Yavatmal","Hinganghat","Madgaon","Verna","Katra","Bilaspur","Uttarkashi","Muktsar","Bhatinda","Pathankot","Khatauli","Vikasnagar","Kollam","Kovilpatti","Kovvur","Paloncha","Vasco","Alwar","Bijapur","Tinsukia","Ratlam","Kalka","Ladwa","Rajpura","Batala","Hoshiarpur","Katni","Bhilwara","Jhajjar","Lohaghat","Mohali","Dhuri","Thoothukudi","Sivakasi","Coonoor","Shimoga","Kayamkulam","Namakkal","Dharmapuri","Aluva","Antapur","Tanuku","Eluru","Balasore","Hingoli","Quepem","Assagao","Betim","Cuncolim","Ahmednagar","Goa","Caranzalem","Chopda","Petlad","Raipur","Villupuram","Shoranur","Dasua","Gonda","Yadgir","Palladam","Nuzvid","Kasaragod","Paonta Sahib","Sarangi","Anantapur","Kumar","Kaul","Panipat","Uppal","Teri","Tiruvalla","Jamal","Chakra","Narasaraopet","Dharamsala","Ranjan","Garhshankar","Haridwar","Chinchvad","Narela","Aurangabad","Sion","Kalamboli","Chittoor","Wellington","Nagapattinam","Karaikal","Pollachi","Thenkasi","Aranmula","Koni","Ariyalur","Ranippettai","Kundan","Lamba Harisingh","Surana","Ghana","Lanka","Kataria","Kotian","Khan","Salt Lake City","Bala","Vazhakulam","Paravur","Nabha","Ongole","Kaladi","Jajpur","Thenali","Mohala","Mylapore","Bank","Khammam","Ring","Maldah","Kavali","Andheri","Baddi","Mahesana","Nila","Gannavaram","Cumbum","Belapur","Phagwara","Rander","Siuri","Bulandshahr","Bilimora","Guindy","Pitampura","Baharampur","Dadri","Boisar","Shiv","Multi","Bhadath","Ulubari","Palghar","Puras","Sikka","Saha","Godhra","Dam Dam","Ekkattuthangal","Sahibabad","Kalol","Bardoli","Wai","Shirgaon","Nehra","Mangalagiri","Latur","Kottakkal","Rewari","Ponnani","Narayangaon","Hapur","Kalpetta","Khurja","Ramnagar","Neral","Sendhwa","Talegaon Dabhade","Kargil","Manali","Jalalabad","Palani","Sirkazhi","Krishnagiri","Hiriyur","Muzaffarnagar","Kashipur","Gampalagudem","Siruseri","Manjeri","Raniganj","Mahim","Bhusawal","Tirur","Sattur","Angul","Puri","Khurda","Dharavi","Ambur","Vashi","Arch","Colaba","Hosur","Kota","Hugli","Anantnag","Murshidabad","Jharsuguda","Jind","Neyveli","Vaniyambadi","Srikalahasti","Liluah","Pali","Bokaro","Sidhi","Asansol","Darjeeling","Kohima","Shahdara","Chandannagar","Nadgaon","Haripad","Sitapur","Vapi","Bambolim","Baidyabati","Connaught Place","Singtam","Shyamnagar","Sikar","Choolai","Mayapur","Puruliya","Habra","Kanchrapara","Goregaon","Tiptur","Kalpakkam","Serampore","Konnagar","Port Blair","Canning","Mahad","Alibag","Pimpri","Panchgani","Karjat","Vaikam","Mhow","Lakhimpur","Madhoganj","Kheri","Gudivada","Avanigadda","Nayagarh","Bemetara","Bhatapara","Ramgarh","Dhubri","Goshaingaon","Bellare","Puttur","Narnaul","Porbandar","Keshod","Dhrol","Kailaras","Morena","Deolali","Banda","Orai","Fatehpur","Mirzapur","Adilabad","Pithapuram","Ramavaram","Amalapuram","Champa","Ambikapur","Korba","Pehowa","Yamunanagar","Shahabad","Hamirpur","Gulbarga","Sagar","Bhadravati","Sirsi","Honavar","Siruguppa","Koppal","Gargoti","Kankauli","Jalna","Parbhani","Koraput","Barpali","Jaypur","Banswara","Tindivanam","Mettur","Srirangam","Deoria","Basti","Padrauna","Budaun","Bolpur","Gujrat","Balurghat","Binnaguri","Guruvayur","Chandauli","Madikeri","Piduguralla","Vinukonda","Berasia","Sultans Battery","Ramanagaram","Angadipuram","Mattanur","Gobichettipalayam","Banga","Sibsagar","Namrup","North Lakhimpur","Dhenkanal","Karanja","Cheyyar","Vandavasi","Arakkonam","Tiruvannamalai","Akividu","Tadepallegudem","Madanapalle","Puttur","Edavanna","Kodungallur","Marmagao","Sanquelim","Sakri","Shahdol","Satna","Thasra","Bundi","Kishangarh","Firozpur","Kot Isa Khan","Barnala","Sunam","Pithoragarh","Jaspur","Jhargram","Dimapur","Churachandpur","Raxaul","Motihari","Munger","Purnea","Mannargudi","Kumbakonam","Eral","Nagercoil","Kanniyakumari","Ramanathapuram","Sivaganga","Rajapalaiyam","Srivilliputhur","Suratgarh","Gohana","Sirsa","Fatehabad","Nurpur","Chamba","Khergam","Dindigul","Pudukkottai","Kaimganj","Tarn Taran","Khanna","Irinjalakuda","Sehore","Parra","Dicholi","Chicalim","Saligao","Changanacheri","Igatpuri","Sangamner","Ganganagar","Kanhangad","Chidambaram","Chittur","Nilambur","Arvi","Jalesar","Kasganj","Chandausi","Beawar","Bharatpur","Kathua","Chalisgaon","Karamsad","Peranampattu","Arani","Payyanur","Pattambi","Pattukkottai","Pakala","Vikarabad","Bhatkal","Rupnarayanpur","Kulti","Koch Bihar","Nongstoin","Budbud","Balangir","Kharar","Mukerian","Mansa","Punalur","Mandya","Nandyal","Dhone","Candolim","Aldona","Solim","Daman","Koothanallur","Sojat","Alanallur","Kagal","Jhunjhunun","Sirhind","Kurali","Khinwara","Machhiwara","Talwandi Sabo","Malpur","Dhar","Medarametla","Pileru","Yercaud","Ottappalam","Alangulam","Palus","Chiplun","Durg","Damoh","Ambarnath","Haveri","Mundgod","Mandvi","Behala","Fort","Bela","Balana","Odhan","Mawana","Firozabad","Bichpuri","Almora","Pauri","Azamgarh","Phaphamau","Nongpoh","Gangrar","Jhalawar","Nathdwara","Jaisalmer","Pushkar","Sirohi","Baroda","Ambah","Ambejogai","Ambad","Osmanabad","Betalbatim","Gangapur","Dindori","Yeola","Pandharpur","Neri","Umred","Patelguda","Patancheru","Singarayakonda","Peddapuram","Gadag","ChikmagalÅ«r","Chikodi","Amer","Chintamani","Tambaram","Palayam","Karamadai","Omalur","Kuzhithurai","Faizabad","Thirumangalam","Kodaikanal","Devipattinam","Dharapuram","Rudrapur","Talcher","Haldia","Karsiyang","Sandur","Bapatla","Shamsabad","Kandi","Ramapuram","Anchal","Trimbak","Calangute","Arpora","Khargone","Mandla","Kalan","Pachmarhi","Dhamtari","Kumhari","Aundh","Tala","Tuljapur","Botad","Sidhpur","Sanand","Nagwa","Mussoorie","Vadamadurai","Sholavandan","Pochampalli","Perundurai","Lalgudi","Ponneri","Mount Abu","Vadner","Shanti Grama","Nalagarh","Pahalgam","Dinanagar","Jatani","Ganga","Barmer","Hoshangabad","Khajuraho Group of Monuments","Betul","Sangola","Tirumala","Mirza Murad","Attur","Budha","Pala","Tonk","Koni","Rajpur","Shrigonda","Hazaribagh","Nagaur","Mandapeta","Nabadwip","Nandurbar","Nazira","Kasia","Bargarh","Kollegal","Shahkot","Jagraon","Channapatna","Madurantakam","Kamalpur","Ranaghat","Mundra","Mashobra","Rama","Chirala","Bawana","Dhaka","Mahal","Chitradurga","Mandsaur","Dewas","Sachin","Andra","Kalkaji Devi","Pilkhuwa","Mehra","Chhachhrauli","Samastipur","Bangaon","Ghatal","Jayanti","Belgharia","Kamat","Dhariwal","Morinda","Kottagudem","Suriapet","Mahesh","Sirwani","Kanakpura","Mahajan","Sodhi","Chand","Nagal","Hong","Raju","Tikamgarh","Parel","Jaynagar","Mill","Khambhat","Ballabgarh","Begusarai","Shahapur","Banka","Golaghat","Palwal","Kalra","Chandan","Maru","Nanda","Chopra","Kasal","Rana","Chetan","Charu","Arora","Chhabra","Bishnupur","Manu","Karimganj","Ellora Caves","Adwani","Amreli","Soni","Sarwar","Balu","Rawal","Darsi","Nandigama","Mathan","Panchal","Jha Jha","Hira","Manna","Amal","Kheda","Abdul","Roshan","Bhandari","Binavas","Hari","Nandi","Rajapur","Suman","Sakri","Khalapur","Dangi","Thiruthani","Bawan","Basu","Kosamba","Medchal","Kakdwip","Kamalpura","Dogadda","Charan","Basirhat","Nagari","Kangayam","Sopara","Nadia","Mahulia","Alipur","Hamirpur","Fatehgarh","Bagh","Naini","Karari","Ajabpur","Jaunpur","Iglas","Pantnagar","Dwarahat","Dasna","Mithapur","Bali","Nilokheri","Kolayat","Haripur","Dang","Chhota Udepur","Matar","Sukma","Guna","Dona Paula","Navelim","Vainguinim","Curchorem","Balaghat","Bhagwan","Vijapur","Sinnar","Mangaon","Hadadi","Bobbili","Yanam","Udaigiri","Balanagar","Kanigiri","Muddanuru","Panruti","Proddatur","Puliyur","Perambalur","Turaiyur","Tiruchchendur","Shadnagar","Markal","Sultan","Rayagada","Kaniyambadi","Vandalur","Sangam","Katoya","Gudur","Farakka","Baramati","Tohana")

        val adapterSearch = ArrayAdapter<String>(
            applicationContext, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, searchItem
        )
        var searchView:AutoCompleteTextView=findViewById(R.id.searchViewtext)
        searchView.setAdapter(adapterSearch)
        searchView.onItemClickListener = object: AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var find = searchView.text.toString()
                fetchmausamData(find)
                val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                if (view != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.applicationWindowToken, 0)
                }
            }

        }

    }



    private fun fetchmausamData(cityname: String) {
        var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)
        val response = retrofit.getmausamData(
            cityname,
            appid = "07c34f60c07d31f7c6129919a7e886f0",
            units = "matric"
        )
        response.enqueue(object : Callback<mausam> {
            override fun onResponse(call: Call<mausam>, response: Response<mausam>) {
                var responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    var temperature = (responseBody.main.temp - 273).toInt().toString()
                    var temp: TextView = findViewById(R.id.temperature)
                    temp.text = "$temperature °C"

                    var humidity = (responseBody.main.humidity).toString()
                    var hum: TextView = findViewById(R.id.humidity)
                    hum.text = "$humidity %"

                    var sea = (responseBody.main.sea_level).toString()
                    var sea_level: TextView = findViewById(R.id.sea)
                    sea_level.text = "$sea hpa"

                    var sun = (responseBody.sys.sunrise).toLong()
                    var sunrise: TextView = findViewById(R.id.sunrise)
                    sunrise.text = "${time(sun)}"

                    var sun_set = (responseBody.sys.sunset).toLong()
                    var sunset: TextView = findViewById(R.id.sunset)
                    sunset.text = "${time(sun_set)}"

                    var wind_speed = (responseBody.wind.speed).toString()
                    var windspeed: TextView = findViewById(R.id.windspeed)
                    windspeed.text = "$wind_speed m/s"

                    var max_temp = (responseBody.main.temp_max - 273).toInt().toString()
                    var maxtemp: TextView = findViewById(R.id.max)
                    maxtemp.text = "Max Tem: $max_temp °C"

                    var min_temp = (responseBody.main.temp_min - 273).toInt().toString()
                    var mintemp: TextView = findViewById(R.id.min)
                    mintemp.text = "Min Tem: ${min_temp} °C"

                    var condition = (responseBody.weather.firstOrNull()?.main ?: "Unknown").toString()
                    var condi_tion: TextView = findViewById(R.id.sunny)
                    var condi__tion: TextView = findViewById(R.id.sunny_)
                    condi_tion.text = "$condition"
                    condi__tion.text = "$condition"

                    var city: TextView = findViewById(R.id.city_name)
                    city.text = cityname
                    var day: TextView = findViewById(R.id.day)
                    day.text = dayname(System.currentTimeMillis())
                    var datename: TextView = findViewById(R.id.date)
                    datename.text = date()
                   changeImageToCondition(condition)

                }
            }

            override fun onFailure(call: Call<mausam>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }

    private fun changeImageToCondition(condition: String) {

        when (condition) {

            "Clear Sky", "Sunny", "Clear", -> {

                var img:ConstraintLayout=findViewById(R.id.background)
                img.setBackgroundResource(R.drawable.sun)
                var anim:LottieAnimationView=findViewById(R.id.lottieAnimationView)
                anim.setAnimation(R.raw.sun)
                anim.playAnimation()

            }

            "Partly Clouds", "Clouds", "Overcast", "Mist", "Fog" -> {

                var img:ConstraintLayout=findViewById(R.id.background)
                img.setBackgroundResource(R.drawable.colud_background)
                var anim:LottieAnimationView=findViewById(R.id.lottieAnimationView)
                anim.setAnimation(R.raw.cloud)
                anim.playAnimation()

            }

            "Light Rain", "Drizzle", "Moderate Rain", "Shower rain", "Rain" -> {

                var img:ConstraintLayout=findViewById(R.id.background)
                img.setBackgroundResource(R.drawable.rain_background)
                var anim:LottieAnimationView=findViewById(R.id.lottieAnimationView)
                anim.setAnimation(R.raw.rain)
                anim.playAnimation()

            }

            "Light Snow", "Moderate Snow", "Heavy Snow", "Blizzard","Haze"-> {

                var img:ConstraintLayout=findViewById(R.id.background)
                img.setBackgroundResource(R.drawable.snow_background)
                var anim:LottieAnimationView=findViewById(R.id.lottieAnimationView)
                anim.setAnimation(R.raw.snow)
                anim.playAnimation()

            }
            else ->{
                var img:ConstraintLayout=findViewById(R.id.background)
                img.setBackgroundResource(R.drawable.sunny)
                var anim:LottieAnimationView=findViewById(R.id.lottieAnimationView)
                anim.setAnimation(R.raw.sun)
                anim.playAnimation()
            }


        }
    }

    fun dayname(timestamp: Long): String {
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format(Date())
    }

    fun date(): String {
        val sdf = SimpleDateFormat("DD MMMM YYYY", Locale.getDefault())
        return sdf.format(Date())
    }

    fun time(timestamp: Long): String {
        val sdf = SimpleDateFormat("HH:MM", Locale.getDefault())
        return sdf.format(Date(timestamp*1000))
    }
}