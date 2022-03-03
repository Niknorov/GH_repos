package com.example.icerock_t1.detail.data

import com.example.icerock_t1.detail.domain.LinksReadmeModel
import com.example.icerock_t1.detail.domain.ReadmeModel
import com.example.icerock_t1.detail.domain.ReadmeRepository
import com.example.icerock_t1.detail.domain.LicenseBaseModel
import com.example.icerock_t1.detail.domain.LicenseModel
import com.example.icerock_t1.detail.domain.LinksLicenseModel

class ReadmeRepositoryImpl(
    private val readmeRemoteDataSource: ReadmeRemoteDataSource,

) : ReadmeRepository {


    override suspend fun getReadme(userName: String, repoName: String): ReadmeModel{

        val readmeDto = readmeRemoteDataSource.getReadme(userName = userName, repoName = repoName)
        return ReadmeModel(
            type = readmeDto.type,
            encoding = readmeDto.encoding,
            size = readmeDto.size,
            name = readmeDto.name,
            path = readmeDto.path,
            content = readmeDto.content,
            sha = readmeDto.sha,
            url = readmeDto.url,
            gitUrl = readmeDto.gitUrl,
            htmlUrl = readmeDto.htmlUrl,
            downloadUrl = readmeDto.downloadUrl,
            links = LinksReadmeModel(
                git = readmeDto.linksLicense.git,
                self = readmeDto.linksLicense.self,
                html = readmeDto.linksLicense.html
            )
        )
    }

    override suspend fun getLicense(userName: String, repoName: String): LicenseBaseModel {

        val licenseBaseDto =
            readmeRemoteDataSource.getLicense(userName = userName, repoName = repoName)
        return LicenseBaseModel(
            name = licenseBaseDto.name,
            path = licenseBaseDto.path,
            size = licenseBaseDto.size,
            sha = licenseBaseDto.sha,
            url = licenseBaseDto.url,
            htmlUrl = licenseBaseDto.htmlUrl,
            gitUrl = licenseBaseDto.gitUrl,
            downloadUrl = licenseBaseDto.downloadUrl,
            type = licenseBaseDto.type,
            content = licenseBaseDto.content,
            encoding = licenseBaseDto.encoding,
            LinksModel = LinksLicenseModel(
                self = licenseBaseDto.linksDto.self,
                git = licenseBaseDto.linksDto.git,
                html = licenseBaseDto.linksDto.html
            ),
            licenseModel = LicenseModel(
                key = licenseBaseDto.licenseDto.key,
                name = licenseBaseDto.licenseDto.name,
                spdxId = licenseBaseDto.licenseDto.spdxId,
                url = licenseBaseDto.licenseDto.url,
                nodeId = licenseBaseDto.licenseDto.nodeId,
            )
        )
    }
}