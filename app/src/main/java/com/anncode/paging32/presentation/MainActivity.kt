package com.anncode.paging32.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anncode.paging32.MyApplication
import com.anncode.paging32.databinding.ActivityMainBinding
import com.anncode.paging32.presentation.view.PokemonAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainActivityViewModel: MainActivityViewModel
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val pokemonAdapter = PokemonAdapter()
        binding?.apply {
            rvPokemons.setHasFixedSize(true)
            rvPokemons.adapter = pokemonAdapter
        }

        mainActivityViewModel.pokemons.observe(this, {
            pokemonAdapter.submitData(lifecycle, it)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
