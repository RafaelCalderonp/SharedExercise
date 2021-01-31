package com.example.sharedexercise

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sharedexercise.databinding.FragmentFirstBinding

private const val sharedPreferenceName = "com.example.sharedexercise"
class FirstFragment : Fragment() {

    private lateinit var mBinding: FragmentFirstBinding
    private lateinit var mSharedPreferens: SharedPreferences


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        mSharedPreferens = activity?.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE)!!
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // mBinding.switch1.setSwitchTextAppearance()
        // Toast.makeText(context, "else 2", Toast.LENGTH_SHORT).show()

        var numero = 0
        var texto = ""
        var numero2 = 0.0f
        val key1 = "key1"
        val key2 = "key2"
        val key3 = "key3"

        val numeroObtenido = mSharedPreferens.getInt(key1, 0)
        val textoObtenido = mSharedPreferens.getString(key2,"")
        val numero2Obtenido = mSharedPreferens.getFloat(key3, 0.0f)


        mBinding.tvInt.setText(numeroObtenido.toString())
        mBinding.tvText.setText(textoObtenido)
        mBinding.tvFloat.setText(numero2Obtenido.toString())

        mBinding.btSave.setOnClickListener {

            if (mBinding.etInt.text.toString().isEmpty()) {
                mBinding.tvInt.setText("Ingrese un numero")
            } else {
                numero = mBinding.etInt.text.toString().toInt()
            }

            if (mBinding.etText.text.toString().isEmpty()){
                mBinding.tvText.setText("Ingrese un Texto")
            }else{
                texto = mBinding.etText.text.toString()
            }

            if (mBinding.ettFloat.text.toString().isEmpty()) {
                mBinding.tvFloat.setText("Ingrese un numero")
            } else {
                numero2 = mBinding.ettFloat.text.toString().toFloat()
            }

            mSharedPreferens.edit().putInt(key1, numero).apply()
            mSharedPreferens.edit().putString(key2, texto).apply()
            mSharedPreferens.edit().putFloat(key3, numero2).apply()


        }
        mBinding.btClear.setOnClickListener {
            mSharedPreferens.edit().clear().apply()
        }




    }
}