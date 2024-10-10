package com.example.vhh.ui.profile

import androidx.compose.ui.res.colorResource
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.theme.AppColor
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
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vhh.ui.data.db.models.Listing
import com.example.vhh.ui.data.db.models.ListingResponse
import com.example.vhh.ui.data.db.models.ShopModel
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
fun MyProfile(navigator: DestinationsNavigator) {
    val viewModel: ProfileViewModel = koinViewModel()
    val user = viewModel.user.observeAsState().value
    val post = viewModel.listings.observeAsState(ListingResponse()).value
    val shop = viewModel.shop.observeAsState(ShopModel()).value
    val favourites = remember {
        mutableStateListOf<Listing>()
    }
    var sizeImage by remember {
        mutableStateOf(IntSize.Zero)
    }
    var activeTab by rememberSaveable {
        mutableStateOf("posts")
    }
    val config = LocalConfiguration.current
    val height = config.screenHeightDp.dp
//    Timber.d("offsetY: $offsetY progress: $progress")
    val gradient = Brush.linearGradient(
        0.0f to Color.Transparent,
        500.0f to Color.Black,
        start = Offset.Zero,
        end = Offset.Infinite,
    )
    val pagerState = rememberPagerState { 2 }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.getListings()
            .addOnSuccessListener {
                favourites.addAll(it.data.filter { it.isStarred })
            }
    }

    LaunchedEffect(pagerState.currentPage) {
        activeTab = if (pagerState.currentPage == 0) {
            "posts"
        } else {
            "favourite"
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
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
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
                    model = user?.coverImage?.get(0)?.replace(Regex("\\bhttp://"), "https://"),
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
                    model = user?.profileImage?.replace(Regex("\\bhttp://"), "https://"),
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
                text = user?.name ?: "",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Text(
                text = user?.address ?: "",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
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
                    text = stringResource(id = R.string.edit_profile),
                ) {
                    navigator.navigate(ChangeProfileDestination)
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
                OutlinedButton(
                    onClick = {
                        navigator.navigate(SettingsDestination)
                    },
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
                        imageVector = Icons.Default.Settings, contentDescription = "",
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
                        text = post.data.size.toString(),
                        style = MaterialTheme.typography.bodyLarge,
                        color = AppColor
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
                        text = shop.followingCount.toString(),
                        style = MaterialTheme.typography.labelLarge,
                        color = AppColor
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
                        text = shop.followers.toString(),
                        style = MaterialTheme.typography.labelLarge,
                        color = AppColor
                    )
                    Text(
                        text = stringResource(id = R.string.followers),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.height(50.dp)
            ) {
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
                            containerColor = if (activeTab == "favourite") Color.Blue else Color.LightGray,
                            contentColor = AppColor
                        ),
                        border = BorderStroke(1.dp, color = colorResource(R.color.green_app)),
                        shape = RoundedCornerShape(60)
                    ) {
                        Text(
                            text = stringResource(id = R.string.favourite_feed),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
            Column(Modifier.height(height.minus(130.dp))) {
                HorizontalPager(state = pagerState) {
                    if (it == 0) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            modifier = Modifier
                                .fillMaxSize()
//                    .nestedScroll(nestedScroll)
                                .padding(horizontal = 2.dp, vertical = 10.dp)
                        ) {
                            items(items = post.data, key = { it.id }) { item ->
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
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            modifier = Modifier
                                .fillMaxSize()
//                    .nestedScroll(nestedScroll)
                                .padding(horizontal = 2.dp, vertical = 10.dp)
                        ) {
                            items(items = favourites, key = { it.id }) { item ->
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
                                    GlideImage(
                                        model = item.media[0],
                                        contentDescription = "post image",
                                        modifier = Modifier
//                                            .padding(end = 3.dp, bottom = 4.dp)
                                            .onGloballyPositioned {
                                                sizeImage = it.size
                                            },
                                        contentScale = ContentScale.FillBounds
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
                    }
                }
            }
        }

    }
}
