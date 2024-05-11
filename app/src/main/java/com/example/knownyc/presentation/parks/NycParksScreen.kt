package com.example.knownyc.presentation.parks

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.knownyc.commons.TAG
import com.example.knownyc.presentation.ui.util.LoadingDialog

// TODO: Project 2

@Composable
fun NycParksScreen(
    modifier: Modifier = Modifier,
    boroughCode: String,
//    searchText: String,
) {
    val viewModel: NycParksViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.setBoroughCode(boroughCode)
    }

    val context = LocalContext.current

    LoadingDialog(isLoading = state.isLoading)
    LazyColumn(
        modifier = modifier
    ) {
        items(state.parks) { park ->
            NycParkCard(
                name = park.name!!
//                painter = painterResource(id = park.image)!!,
            ) {
                Log.d(TAG, "clicked: ${park.name}")
                openUrl(context, park.url)

            }
        }
    }
}

fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
