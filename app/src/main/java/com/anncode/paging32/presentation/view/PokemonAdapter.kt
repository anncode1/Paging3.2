package com.anncode.paging32.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anncode.paging32.data.model.Pokemon
import com.anncode.paging32.databinding.PokemonItemViewBinding

/**
 * Created by anahi.salgado on 03-Dec-21.
 */
class PokemonAdapter : PagingDataAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(POKEMON_COMPARATOR) {

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        pokemon?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = PokemonItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    class PokemonViewHolder(
        private val binding: PokemonItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon) {
            binding.tvPokemonName.text = pokemon.name
        }

    }

    companion object {
        private val POKEMON_COMPARATOR = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem.url == newItem.url

        }
    }
}
