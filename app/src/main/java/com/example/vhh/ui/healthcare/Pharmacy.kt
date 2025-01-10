package com.example.vhh.ui.healthcare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.AddCart
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun Pharmacy (navigator: DestinationsNavigator
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp))
                .height(150.dp),
            backgroundColor = AppColor
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Image(painter = painterResource(id = R.drawable.whitesms), contentDescription = "",
                    modifier = Modifier.clickable { })
                Text(
                    text = stringResource(id = R.string.pharmacy),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier
                        .paddingFromBaseline(top = 10.dp)
                )
                Image(painter = painterResource(id = R.drawable.bell),
                    contentDescription = "",
                    modifier
                    = Modifier.clickable { })
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier.horizontalScroll(scrollState)
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier.size(width = 131.dp, height = 40.dp)
                    .clickable { },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(40),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    text = stringResource(id = R.string.all),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = AppColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)

                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Surface(
                modifier = Modifier.size(width = 131.dp, height = 40.dp)
                    .clickable { },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(40),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    text = stringResource(id = R.string.vitamin),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = AppColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)

                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Surface(
                modifier = Modifier.size(width = 131.dp, height = 40.dp)
                    .clickable { },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(40),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    text = stringResource(id = R.string.heart_burn),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = AppColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Surface(
                modifier = Modifier.size(width = 131.dp, height = 40.dp)
                    .clickable { },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(40),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    text = stringResource(id = R.string.vitamin),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = AppColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Surface(
                modifier = Modifier.size(width = 131.dp, height = 40.dp)
                    .clickable { },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(40),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    text = stringResource(id = R.string.all),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = AppColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d1), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d2), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d3), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d4), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d5), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d6), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d1), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d2), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 10.dp
                    ),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d3), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 180.dp)
                    .clickable {
                    },
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 10.dp
                    ),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painterResource(R.drawable.love), contentDescription = null,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painterResource(R.drawable.d5), contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column {
                            Text(
                                text = "B2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = "200ml",
                                fontWeight = FontWeight.Thin,
                                fontSize = 10.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "N40,000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
//                        AddCart(navigator = navigator)
                    }
                }
            }
        }
    }
}
