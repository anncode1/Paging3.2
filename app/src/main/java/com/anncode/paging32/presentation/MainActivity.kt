package com.anncode.paging32.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.anncode.paging32.MyApplication
import com.anncode.paging32.databinding.ActivityMainBinding
import com.anncode.paging32.presentation.view.PokemonAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainActivityViewModel: MainActivityViewModel
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        val pokemonAdapter = PokemonAdapter()
        binding?.apply {
            rvPokemons.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPokemons.setHasFixedSize(true)
            rvPokemons.adapter = pokemonAdapter
        }


        lifecycleScope.launch {
            mainActivityViewModel.pokemons.collect {
                pokemonAdapter.submitData(it)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
