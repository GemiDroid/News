package com.gemidroid.news.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gemidroid.news.R
import com.gemidroid.news.data.entities.Articles
import com.gemidroid.news.presentation.ui.ArticlesAdapter
import com.gemidroid.news.presentation.ui.viewmodel.GetNewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.articles_list.*
import kotlinx.android.synthetic.main.fragment_base.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException

abstract class BaseFragment : Fragment() {

    private val viewModel by sharedViewModel<GetNewsViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rec_articles.setHasFixedSize(true)

        viewModel.observeOnArticles().observe(viewLifecycleOwner, Observer {
            rec_articles.adapter = ArticlesAdapter(representListItems(it),requireActivity())
        })

        viewModel.isLoading().observe(viewLifecycleOwner, Observer {
            progress.apply {
                visibility = if(it) VISIBLE
                else GONE
            }
        })
        viewModel.observeOnErrors().observe(viewLifecycleOwner, Observer {
           val message = when(it) {
                is UnknownHostException-> getString(R.string.no_internet_connection)
               else-> getString(R.string.unknown_error) }
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
        })
    }

    abstract fun representListItems(allNews: List<Articles>): List<Articles>
}