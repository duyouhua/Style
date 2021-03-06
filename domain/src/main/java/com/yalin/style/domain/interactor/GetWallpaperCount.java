package com.yalin.style.domain.interactor;


import com.yalin.style.domain.executor.PostExecutionThread;
import com.yalin.style.domain.executor.SerialThreadExecutor;
import com.yalin.style.domain.executor.ThreadExecutor;
import com.yalin.style.domain.repository.SourcesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author jinyalin
 * @since 2017/4/28.
 */

public class GetWallpaperCount extends UseCase<Integer, Void> {
    private SourcesRepository sourcesRepository;

    @Inject
    public GetWallpaperCount(ThreadExecutor threadExecutor,
                             SerialThreadExecutor serialThreadExecutor,
                             PostExecutionThread postExecutionThread,
                             SourcesRepository sourcesRepository) {
        super(threadExecutor, serialThreadExecutor, postExecutionThread);
        this.sourcesRepository = sourcesRepository;
    }

    @Override
    Observable<Integer> buildUseCaseObservable(Void aVoid) {
        return sourcesRepository.getWallpaperRepository().getWallpaperCount();
    }
}
