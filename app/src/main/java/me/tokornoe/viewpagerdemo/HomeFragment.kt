package me.tokornoe.viewpagerdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var wordViewModel: WordViewModel
    private val newWordActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView =  view.findViewById(R.id.recyclerview) as RecyclerView
        val adapter = activity?.let { WordListAdapter(it) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        wordViewModel.allWords.observe(viewLifecycleOwner, Observer { words ->
            //update the cached copy of the words in the adapter.
            words?.let {
                adapter?.setWords(it)
            }
        })
        return view
    }


}