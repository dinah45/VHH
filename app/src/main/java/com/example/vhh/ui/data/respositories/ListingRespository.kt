package com.example.vhh.ui.data.respositories

import com.example.vhh.ui.data.db.doas.ListingDao
import com.example.vhh.ui.data.db.models.Listing


class ListingRepository(private val listingDao: ListingDao) {
    suspend fun addListings(listings: List<Listing>) = listingDao.replaceListings(listings)
    fun getListings() = listingDao.getListings()

    //    fun getChain(chainId: Int) = chainDao.getChain(chainId)
    suspend fun updateListing(listing: Listing) = listingDao.updateListing(listing)

    //delete a user
    suspend fun deleteAll() = listingDao.deleteAll()
}
