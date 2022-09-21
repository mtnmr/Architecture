package com.example.mvpsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import coil.load
import com.example.mvpsample.presenter.MainContract
import com.example.mvpsample.presenter.MainPresenter
import com.example.mvpsample.repository.local.PreferenceManager
import com.example.mvpsample.repository.remote.ApiClientManager
import com.google.android.material.textfield.TextInputEditText

class MainFragment : Fragment(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter
    lateinit var editText :TextInputEditText
    lateinit var button : Button
    lateinit var textView : TextView

    lateinit var pokeName: TextView
    lateinit var pokeImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.edit_text)
        button = view.findViewById(R.id.set_text_button)
        textView = view.findViewById(R.id.current_text)
        pokeName = view.findViewById(R.id.poke_name)
        pokeImage = view.findViewById(R.id.poke_image)

        presenter = MainPresenter(this, PreferenceManager(requireContext()), ApiClientManager())
        presenter.start()

        button.setOnClickListener {
            presenter.onClickButton(editText.text.toString())
        }
    }


    override fun showNumber(id: String) {
        textView.text = id
    }

    override fun showPokeName(name: String) {
        pokeName.text = name
    }

    override fun showPokeImage(imageUrl: String) {
        val imgURL = imageUrl.toUri().buildUpon().scheme("https").build()
        pokeImage.load(imgURL)
    }
}