package com.example.vhh.ui.profile
//
//import android.widget.PopupMenu.OnDismissListener
//import android.widget.Space
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.AlertDialog
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Card
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Icon
//import androidx.compose.material.Surface
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.Divider
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.window.Popup
//import com.example.vhh.R
//import com.example.vhh.ui.components.Custom
//import com.example.vhh.ui.components.VhhButton
//import com.example.vhh.ui.components.VhhButton1
//import com.example.vhh.ui.theme.AppColor
//import com.ramcosta.composedestinations.annotation.Destination
//import com.ramcosta.composedestinations.navigation.DestinationsNavigator
//
//@OptIn(ExperimentalMaterialApi::class)
//@ExperimentalComposeUiApi
//@Destination
//@Composable
//fun Profile (
//   navigator: DestinationsNavigator
//) {
//    val scrollState = rememberScrollState()
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(scrollState)
//            .background(color = Color.LightGray.copy(0.5f)),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp))
//                .height(250.dp),
//            backgroundColor = AppColor
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 24.dp, vertical = 34.dp),
//                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
//                verticalAlignment = Alignment.Top
//            ) {
//                Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "",
//                    modifier = Modifier.clickable { })
//                Spacer(modifier = Modifier.weight(1f))
//                Image(painter = painterResource(id = R.drawable.vec), contentDescription = "",
//                    modifier = Modifier.clickable { })
//                Spacer(modifier = Modifier.width(10.dp))
//                Image(painter = painterResource(id = R.drawable.bell),
//                    contentDescription = "",
//                    modifier
//                    = Modifier.clickable { })
//            }
//            Text(
//                text = stringResource(id = R.string.profile),
//                fontWeight = FontWeight.Medium,
//                fontSize = 25.sp,
//                color = Color.White,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .padding(top = 70.dp)
//            )
//        }
//        Row(
//            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Surface(
//                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
//                shape = RoundedCornerShape(20),
//                color = Color.White.copy(0.7f),
//            ) {
//                Column(
//
//                    modifier = Modifier,
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(painterResource(R.drawable.test), contentDescription = null)
//                    Text(
//                        "Test results", fontWeight = FontWeight.Medium,
//                        fontSize = 13.sp,
//                        color = Color.Black
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.weight(1f))
//            Surface(
//                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
//                shape = RoundedCornerShape(20),
//                color = Color.White.copy(0.7f),
//            ) {
//                Column(
//
//                    modifier = Modifier,
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(painterResource(R.drawable.alarm), contentDescription = null)
//                    Text(
//                        "Medication Schedule", fontWeight = FontWeight.Medium,
//                        fontSize = 13.sp,
//                        color = Color.Black
//                    )
//                }
//            }
//        }
//        Spacer(modifier = Modifier.height(10.dp))
//        Row(
//            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Surface(
//                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
//                shape = RoundedCornerShape(20),
//                color = Color.White.copy(0.7f),
//            ) {
//                Column(
//
//                    modifier = Modifier,
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(painterResource(R.drawable.tube), contentDescription = null)
//                    Text(
//                        "Prescription", fontWeight = FontWeight.Medium,
//                        fontSize = 13.sp,
//                        color = Color.Black
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.weight(1f))
//            Surface(
//                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
//                shape = RoundedCornerShape(20),
//                color = Color.White.copy(0.7f),
//            ) {
//                Column(
//
//                    modifier = Modifier,
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(painterResource(R.drawable.table), contentDescription = null)
//                    Text(
//                        "Medical history", fontWeight = FontWeight.Medium,
//                        fontSize = 13.sp,
//                        color = Color.Black
//                    )
//                }
//            }
//        }
//Spacer(modifier = Modifier.height(15.dp))
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(32.dp)
//                .padding(horizontal = 16.dp)
//                .clickable { },
//            shape = RoundedCornerShape(40),
//            color = Color.White.copy(0.7f),
//            contentColor = Color.Black) {
//            Row(
//                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Start
//            ) {
//                Text(
//                    "Appointment history",
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 13.sp,
//                    color = Color.Black
//                )
//                Spacer(modifier = Modifier.weight(1f))
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
//            }
//        }
//
//Spacer(modifier = Modifier.height(10.dp))
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(32.dp)
//                .padding(horizontal = 16.dp)
//                .clickable { },
//            shape = RoundedCornerShape(40),
//            color = Color.White.copy(0.7f),
//            contentColor = Color.Black){
//            Row(
//                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Start
//            ) {
//                Text(
//                    "Favourites ",
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 13.sp,
//                    color = Color.Black
//                )
//                Spacer(modifier = Modifier.weight(1f))
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
//            }
//        }
//
//Spacer(modifier = Modifier.height(10.dp))
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(32.dp)
//                .padding(horizontal = 16.dp)
//                .clickable { },
//            shape = RoundedCornerShape(40),
//            color = Color.White.copy(0.7f),
//            contentColor = Color.Black){
//            Row(
//                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Start
//            ) {
//                Text(
//                    "Payment Info ",
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 13.sp,
//                    color = Color.Black
//                )
//                Spacer(modifier = Modifier.weight(1f))
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
//            }
//        }
//
//Spacer(modifier = Modifier.height(10.dp))
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(32.dp)
//                .padding(horizontal = 16.dp)
//                .clickable { },
//            shape = RoundedCornerShape(40),
//            color = Color.White.copy(0.7f),
//            contentColor = Color.Black){
//            Row(
//                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Start
//            ) {
//                Text(
//                    "Settings ",
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 13.sp,
//                    color = Color.Black
//                )
//                Spacer(modifier = Modifier.weight(1f))
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
//            }
//        }
//
//Spacer(modifier = Modifier.height(10.dp))
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(32.dp)
//                .padding(horizontal = 16.dp)
//                .clickable { },
//            shape = RoundedCornerShape(40),
//            color = Color.White.copy(0.7f),
//            contentColor = Color.Black){
//            Row(
//                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Start
//            ) {
//                Text(
//                    "Notification ",
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 13.sp,
//                    color = Color.Black
//                )
//                Spacer(modifier = Modifier.weight(1f))
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
//            }
//        }
//Spacer(modifier = Modifier.height(10.dp))
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(32.dp)
//                .padding(horizontal = 16.dp)
//                .clickable { },
//            shape = RoundedCornerShape(40),
//            color = Color.White.copy(0.7f),
//            contentColor = Color.Black){
//            Row(
//                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Start
//            ) {
//                Text(
//                    "Support ",
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 13.sp,
//                    color = Color.Black
//                )
//                Spacer(modifier = Modifier.weight(1f))
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
//            }
//        }
//        Text(
//            "Log Out ",
//            fontWeight = FontWeight.Normal,
//            fontSize = 18.sp,
//            color = AppColor,
//            modifier = Modifier.padding(start = 15.dp)
//        )
//        }
//    }
//
//package com.cakkie.ui.screens.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.data.db.models.Listing
import com.example.vhh.ui.data.db.models.ShopModel
import com.example.vhh.ui.theme.AppColor
import com.example.vhh.ui.utill.formatDate
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.skydoves.landscapist.ShimmerParams
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalFoundationApi::class)
@Destination
@Composable
fun Profile(id: String, shop: ShopModel = ShopModel(), navigator: DestinationsNavigator) {
    val viewModel: ProfileViewModel = koinViewModel()
    var item by rememberSaveable {
        mutableStateOf(shop)
    }
    val listings = remember {
        mutableStateListOf<Listing>()
    }
    var activeTab by rememberSaveable {
        mutableStateOf("posts")
    }
    var sizeImage by remember {
        mutableStateOf(IntSize.Zero)
    }
    val config = LocalConfiguration.current
    val height = config.screenHeightDp.dp
    val pagerState = rememberPagerState { 2 }
    val scope = rememberCoroutineScope()
    val gradient = Brush.linearGradient(
        0.0f to Color.Transparent,
        500.0f to Color.Black,
        start = Offset.Zero,
        end = Offset.Infinite,
    )
    LaunchedEffect(Unit) {
        viewModel.getShop(id)
            .addOnSuccessListener {
                item = it
            }

        viewModel.getShopListings(id)
            .addOnSuccessListener {
                listings.addAll(it.data)
            }
    }

    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage == 0) {
            activeTab = "posts"
        } else {
            activeTab = "about"
        }
    }
    Column {
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        ) {
            Image(
                painterResource(id = R.drawable.arrow), contentDescription = "Go back",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(24.dp)
                    .align(Alignment.CenterStart)
                    .clickable {
                        navigator.popBackStack()
                    },
            )
            Text(
                text = stringResource(id = R.string.profile),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(150.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                var isLoading by remember {
                    mutableStateOf(true)
                }
                AsyncImage(
                    model = item.image,
                    contentDescription = "cover",
                    contentScale = ContentScale.Crop,
                    onState = {
                        //update isLoaded
                        isLoading = it is AsyncImagePainter.State.Loading
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                        .height(100.dp)
                        .placeholder(
                            visible = isLoading,
                            highlight = PlaceholderHighlight.shimmer(),
                            color = AppColor.copy(0.8f)
                        )
                )
                var loading by remember {
                    mutableStateOf(true)
                }
                AsyncImage(
                    model = item.image,
                    contentDescription = "profile pic",
                    contentScale = ContentScale.Crop,
                    onState = {
                        //update isLoaded
                        loading = it is AsyncImagePainter.State.Loading
                    },
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .size(100.dp)
                        .clip(RoundedCornerShape(100))
                        .border(
                            width = 3.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(100)
                        )
                        .placeholder(
                            visible = loading,
                            highlight = PlaceholderHighlight.shimmer(),
                            color = AppColor.copy(0.8f)
                        )
                )
            }
            Text(
                text = item.name,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = item.address,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                VhhButton (
                    text = stringResource(id = R.string.follow)
                ) {
                }
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .size(width = 70.dp, height = 34.dp),
                    border = BorderStroke(1.dp, color = colorResource(R.color.green_app)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = AppColor
                    ),
                    shape = RoundedCornerShape(20)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.sms), contentDescription = "",
                        modifier = Modifier,
                        tint = AppColor
                    )
                }
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .size(width = 70.dp, height = 34.dp),
                    border = BorderStroke(1.dp, color = colorResource(R.color.green_app)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = AppColor
                    ),
                    shape = RoundedCornerShape(20)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share, contentDescription = "",
                        modifier = Modifier,
                        tint = AppColor
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(start = 31.dp, end = 31.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = listings.size.toString(),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = stringResource(id = R.string.posts),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Divider(
                    color = AppColor,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = item.followingCount.toString(),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = stringResource(id = R.string.following),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Divider(
                    color = AppColor,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = item.followers.toString(),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "Followers",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    },
                    modifier = Modifier
                        .size(width = 90.dp, height = 34.dp),
                    border = BorderStroke(1.dp, color = colorResource(R.color.green_app)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (activeTab == "posts") Color.Blue else Color.LightGray,
                        contentColor = AppColor
                    ),
                    shape = RoundedCornerShape(60)
                ) {
                    Text(
                        text = stringResource(id = R.string.posts),
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    },
                    modifier = Modifier
                        .height(34.dp)
                        .padding(start = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (activeTab == "about") Color.Blue else Color.LightGray,
                        contentColor = AppColor
                    ),
                    border = BorderStroke(1.dp, color = colorResource(R.color.green_app)),
                    shape = RoundedCornerShape(60)
                ) {
                    Text(
                        text = stringResource(id = R.string.about),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            Column(Modifier.height(height.minus(120.dp))) {
                HorizontalPager(state = pagerState) {
                    if (it == 0) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            modifier = Modifier
                                .fillMaxSize()
//                    .nestedScroll(nestedScroll)
                                .padding(horizontal = 2.dp, vertical = 10.dp)
                        ) {
                            items(items = listings, key = { it.id }) { item ->
                                Box(
                                    modifier = Modifier
                                        .clickable {
                                            navigator.navigate(
                                                ItemDetailsDestination(
                                                    id = item.id,
                                                    item
                                                )
                                            )
                                        }
                                        .padding(2.dp)
                                        .size(width = 118.dp, height = 116.dp),
                                    contentAlignment = Alignment.BottomEnd
                                ) {
                                    com.skydoves.landscapist.glide.GlideImage(
                                        imageModel = item.media[0],
                                        contentDescription = "post image",
                                        modifier = Modifier
//                                            .padding(end = 3.dp, bottom = 4.dp)
                                            .onGloballyPositioned {
                                                sizeImage = it.size
                                            },
                                        contentScale = ContentScale.FillBounds,
                                        shimmerParams = ShimmerParams(
                                            baseColor = AppColor.copy(0.8f),
                                            highlightColor = Color.LightGray,
                                            durationMillis = 1000,
                                            dropOff = 0.5f,
                                            tilt = 20f
                                        ),
                                    )
                                    Box(
                                        modifier = Modifier
                                            .matchParentSize()
                                            .background(gradient)
                                    )
                                    Row(
                                        modifier = Modifier.padding(end = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.gridicons_heart),
                                            contentDescription = "",
                                            modifier = Modifier.size(12.dp)
                                        )
                                        Text(
                                            text = item.totalLikes.toString(),
                                            style = MaterialTheme.typography.displaySmall,
                                            modifier = Modifier.padding(start = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    } else {
                        Column(Modifier.fillMaxSize()) {
                            Text(
                                text = item.description,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(16.dp)
                            )
                            Text(
                                text = "Joined since ${item.createdAt.formatDate()}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                            Text(
                                text = "Owned by ${item.user.name}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                            Text(
                                text = "Total orders ${0}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )


                        }
                    }
                }
            }
        }
    }
}


