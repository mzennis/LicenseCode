package com.novia.licencecode.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by mzennis on 12/21/16.
 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {

	private int previousTotal = 0;
	private boolean loading = true;
	private int visibleThreshold = 1;
	int firstVisibleItem, visibleItemCount, totalItemCount;

	private int offset = 0;
	private int limit = 0;

	private RecyclerView.LayoutManager mLayoutManager;
	private boolean isUseLinearLayoutManager = false;
	private boolean isUseGridLayoutManager = false;

	public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager, int offset, int limit) {
		this.mLayoutManager = linearLayoutManager;
		isUseLinearLayoutManager = true;
		this.offset = offset;
		this.limit = limit;
	}

	@Override
	public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
		super.onScrolled(recyclerView, dx, dy);

		if (isUseLinearLayoutManager && mLayoutManager instanceof LinearLayoutManager) {
			firstVisibleItem = ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
		}

		if (isUseGridLayoutManager && mLayoutManager instanceof GridLayoutManager) {
			firstVisibleItem = ((GridLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
		}

		visibleItemCount = mLayoutManager.getChildCount();
		totalItemCount = mLayoutManager.getItemCount();

		if (loading) {
			if (totalItemCount > previousTotal) {
				loading = false;
				previousTotal = totalItemCount;
			}
		}
		if (!loading && (totalItemCount - visibleItemCount)
				<= (firstVisibleItem + visibleThreshold)
				&& totalItemCount >= limit) {
			// End has been reached

			// Do something
			offset = totalItemCount - 1;

			onLoadMore(offset);

			loading = true;
		}
	}

	public abstract void onLoadMore(int offset);
}