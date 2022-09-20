package com.example.mvpsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.mvpsample.presenter.MainContract
import com.example.mvpsample.presenter.MainPresenter
import com.example.mvpsample.repository.PreferenceManager
import com.google.android.material.textfield.TextInputEditText

class MainFragment : Fragment(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter
    lateinit var editText :TextInputEditText
    lateinit var button : Button
    lateinit var textView : TextView

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

        presenter = MainPresenter(this, PreferenceManager(requireContext()))
        presenter.start()

        button.setOnClickListener {
            presenter.onClickButton(editText.text.toString())
        }
    }

    override fun showTextView(text: String) {
        textView.text = text
    }
}