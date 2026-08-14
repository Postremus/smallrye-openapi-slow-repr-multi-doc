package org.acme;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import org.acme.model.AccessType;
import org.acme.model.AccountData;
import org.acme.model.AccountEmailChangeMessageData;
import org.acme.model.AccountInfoData;
import org.acme.model.AccountMessageData;
import org.acme.model.AdapterConfigurationData;
import org.acme.model.AdapterData;
import org.acme.model.AdapterInputData;
import org.acme.model.AdapterType;
import org.acme.model.AdapterUserData;
import org.acme.model.ApplicationData;
import org.acme.model.ApplicationDataV3;
import org.acme.model.ApplicationDataV4;
import org.acme.model.ApplicationGroupData;
import org.acme.model.ApplicationGroupDataV2;
import org.acme.model.ApplicationGroupDataV3;
import org.acme.model.ApplicationGroupInputDataV2;
import org.acme.model.ApplicationGroupInputDataV3;
import org.acme.model.ApplicationGroupMessageData;
import org.acme.model.ApplicationInputData;
import org.acme.model.ApplicationMessageData;
import org.acme.model.AuthorizationContextDataV2;
import org.acme.model.AuthorizationContextDataV3;
import org.acme.model.ChangePasswordInputData;
import org.acme.model.ClientCredentialsData;
import org.acme.model.ContextApplicationData;
import org.acme.model.ContextApplicationDataV2;
import org.acme.model.ContextApplicationDataV3;
import org.acme.model.ContextData;
import org.acme.model.ContextData1;
import org.acme.model.ContextDataV3;
import org.acme.model.ContextTokenData;
import org.acme.model.CountryData;
import org.acme.model.DesignCategoryTypeData;
import org.acme.model.DesignCategoryTypeInputData;
import org.acme.model.DesignGroupTypeData;
import org.acme.model.DesignGroupTypeInputData;
import org.acme.model.DesignProfileData;
import org.acme.model.DesignProfileInputData;
import org.acme.model.DesignSettingTypeData;
import org.acme.model.DesignSettingTypeInputData;
import org.acme.model.DomainRealmMappingData;
import org.acme.model.ExternalOrganizationImportRequestData;
import org.acme.model.ExternalOrganizationImportRequestDataV2;
import org.acme.model.ExternalProfileData;
import org.acme.model.ExternalProfileImportRequestData;
import org.acme.model.IDLongListInputData;
import org.acme.model.ImageDesignData;
import org.acme.model.ImageType;
import org.acme.model.KeycloakClientRepresentationData;
import org.acme.model.OIDCClientIdData;
import org.acme.model.OIDCClientIdDataV2;
import org.acme.model.OIDCClientIdInputData;
import org.acme.model.OIDCClientIdInputDataV2;
import org.acme.model.OIDCUserData;
import org.acme.model.OrganizationDetailData;
import org.acme.model.OrganizationDetailDataV2;
import org.acme.model.OrganizationInputData;
import org.acme.model.OrganizationInputDataV2;
import org.acme.model.OrganizationMessageData;
import org.acme.model.OrganizationTypeData;
import org.acme.model.OrganizationTypeDataV2;
import org.acme.model.OrganizationalChartNodeData;
import org.acme.model.PaginationListAccountListData;
import org.acme.model.PaginationListApplicationDataV2;
import org.acme.model.PaginationListApplicationDataV3;
import org.acme.model.PaginationListApplicationDataV4;
import org.acme.model.PaginationListApplicationGroupDataV2;
import org.acme.model.PaginationListApplicationGroupDataV3;
import org.acme.model.PaginationListDesignProfileData;
import org.acme.model.PaginationListDomainRealmMappingData;
import org.acme.model.PaginationListExternalOrganizationData;
import org.acme.model.PaginationListExternalOrganizationDataV2;
import org.acme.model.PaginationListOrganizationDetailData;
import org.acme.model.PaginationListOrganizationDetailDataV2;
import org.acme.model.PaginationListPostData;
import org.acme.model.PaginationListProductData;
import org.acme.model.PaginationListProfileDataV2;
import org.acme.model.PaginationListProfileDataV3;
import org.acme.model.PaginationListProfileGroupData;
import org.acme.model.PaginationListProfileGroupDataV2;
import org.acme.model.PaginationListProfileTagData;
import org.acme.model.PaginationListTenantData;
import org.acme.model.PaginationListTenantDataV2;
import org.acme.model.PasswordPolicyData;
import org.acme.model.PostAlertResultData;
import org.acme.model.PostCategory;
import org.acme.model.PostData;
import org.acme.model.PostInputData;
import org.acme.model.ProductTenantKpiData;
import org.acme.model.ProfileCreateDataV3;
import org.acme.model.ProfileDataV2;
import org.acme.model.ProfileDataV3;
import org.acme.model.ProfileGroupData;
import org.acme.model.ProfileGroupDataV2;
import org.acme.model.ProfileGroupInputData;
import org.acme.model.ProfileGroupInputDataV2;
import org.acme.model.ProfileGroupMessageData;
import org.acme.model.ProfileInputDataV2;
import org.acme.model.ProfileMessageData;
import org.acme.model.ProfileTagData;
import org.acme.model.ProfileTagInputData;
import org.acme.model.ProfileTagMessageData;
import org.acme.model.ProfileUpdateDataV3;
import org.acme.model.RelationShipKind;
import org.acme.model.RightCategoryData;
import org.acme.model.SalutationData;
import org.acme.model.SalutationDataV2;
import org.acme.model.ServiceLinkData;
import org.acme.model.ServiceLinkInputData;
import org.acme.model.Status;
import org.acme.model.TenantApplicationData;
import org.acme.model.TenantApplicationDataV2;
import org.acme.model.TenantApplicationDataV3;
import org.acme.model.TenantChangedData;
import org.acme.model.TenantCreateInputData;
import org.acme.model.TenantCreateInputDataV2;
import org.acme.model.TenantData;
import org.acme.model.TenantDataV2;
import org.acme.model.TenantMessageData;
import org.acme.model.TenantUsersApplicationsKpiData;
import org.acme.model.TokenData;
import org.acme.model.UUIDListInputData;
import org.acme.model.UserModelData;
import org.acme.model.UserTokenPrincipal;
import org.acme.model.VersionInfoData;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date =
        "2026-06-12T06:27:49" + ".020268300" + "+02:00[Europe/Berlin]", comments = "Generator version: 7.22.0")
public class PortalServiceApi {


    @POST
    @Path("/accounts/{accountId}/avatar")
    @Consumes({ "multipart/form-data" })
    @Produces({ "image/png" })
    public RestResponse<File> accountResourceChangeAvatar(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId, @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/accounts/{accountId}/change-email")
    @Produces({ "application/json" })
    public RestResponse<String> accountResourceChangeEmail(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId,@QueryParam("email") @NotNull @Size(max=255)   String email) {
        return RestResponse.ok();
    }

    @POST
    @Path("/accounts/{accountId}/change-password")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> accountResourceChangePassword(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId,@Valid @NotNull ChangePasswordInputData changePasswordInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/accounts/{accountId}")
    @Produces({ "application/json" })
    public RestResponse<Void> accountResourceDelete(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/accounts/{accountId}/avatar")
    @Produces({ "application/json" })
    public RestResponse<Void> accountResourceDeleteAvatar(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/accounts/{accountId}")
    @Produces({ "application/json" })
    public RestResponse<AccountData> accountResourceRead(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/accounts/{accountId}/contexts")
    @Produces({ "application/json" })
    public RestResponse<List<ContextDataV3>> accountResourceReadContexts(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/accounts/{accountId}/avatar")
    @Produces({ "image/png" })
    public RestResponse<File> accountResourceReadImage(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/accounts/{accountId}/password-policy")
    @Produces({ "application/json" })
    public RestResponse<PasswordPolicyData> accountResourceReadPasswordPolicy(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/accounts")
    @Produces({ "application/json" })
    public RestResponse<PaginationListAccountListData> accountResourceSearch(@QueryParam("createDateTimeMax") Date createDateTimeMax,
            @QueryParam("createDateTimeMin") Date createDateTimeMin, @QueryParam("deleted") @DefaultValue("false") Boolean deleted,
            @QueryParam("email") @Size(min = 1) String email, @QueryParam("firstName") @Size(min = 1) String firstName,
            @QueryParam("includeServiceProviders") Boolean includeServiceProviders, @QueryParam("includeTechnical") Boolean includeTechnical,
            @QueryParam("isServiceProvider") Boolean isServiceProvider, @QueryParam("isTechnical") Boolean isTechnical,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("lastName") @Size(min = 1) String lastName,
            @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax, @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin,
            @QueryParam("locale") @Pattern(regexp = "[a-z]{2}-[A-Z]{2}") String locale, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("profileTagId") Set<UUID> profileTagId,
            @QueryParam("salutationId") Long salutationId, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("email") String sortAttribute, @QueryParam("status") Boolean status,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantName") String tenantName) {
        return RestResponse.ok();
    }

    @POST
    @Path("/accounts/{accountId}/contexts/{contextid}/primary")
    @Produces({ "application/json" })
    public RestResponse<ContextDataV3> accountResourceTogglePrimary(
            @PathParam("accountId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId,
            @PathParam("contextid") @Pattern(regexp = "\\S") String contextid) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/accounts/{accountId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<AccountData> accountResourceUpdate(@PathParam("accountId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId,@Valid @NotNull AccountData accountData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/masterdata/application-groups")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupDataV2> applicationGroupResourceV2Create(@Valid @NotNull ApplicationGroupInputDataV2 applicationGroupInputDataV2) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v2/masterdata/application-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> applicationGroupResourceV2Delete(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/application-groups")
    @Produces({ "application/json" })
    public RestResponse<PaginationListApplicationGroupDataV2> applicationGroupResourceV2ListApplicationGroups(
            @QueryParam("displayOnDashboard") Boolean displayOnDashboard, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("name") String name, @QueryParam("order") Integer order, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/application-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupDataV2> applicationGroupResourceV2Read(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v2/masterdata/application-groups/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupDataV2> applicationGroupResourceV2Update(@PathParam("id") Long id,@Valid @NotNull ApplicationGroupInputDataV2 applicationGroupInputDataV2) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/masterdata/application-groups")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupDataV3> applicationGroupResourceV3Create(
            @Valid @NotNull ApplicationGroupInputDataV3 applicationGroupInputDataV3) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v3/masterdata/application-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> applicationGroupResourceV3Delete(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/masterdata/application-groups")
    @Produces({ "application/json" })
    public RestResponse<PaginationListApplicationGroupDataV3> applicationGroupResourceV3ListApplicationGroups(
            @QueryParam("displayOnDashboard") Boolean displayOnDashboard, @QueryParam("displayOnSidebar") Boolean displayOnSidebar,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("name") String name, @QueryParam("order") Integer order,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/masterdata/application-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupDataV3> applicationGroupResourceV3Read(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v3/masterdata/application-groups/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupDataV3> applicationGroupResourceV3Update(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull ApplicationGroupInputDataV3 applicationGroupInputDataV3) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/applications/{id}/icon-image")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationData> applicationResourceChangeIconImage(@PathParam("id") Long id, @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/applications/{id}/image")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationData> applicationResourceChangeImage(@PathParam("id") Long id, @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/applications")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationData> applicationResourceCreate(@Valid @NotNull ApplicationInputData applicationInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/masterdata/applications/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> applicationResourceDelete(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/applications")
    @Produces({ "application/json" })
    public RestResponse<List<ApplicationData>> applicationResourceList(@QueryParam("includeImages")   Boolean includeImages) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/applications/{id}")
    @Produces({ "application/json" })
    public RestResponse<ApplicationData> applicationResourceRead(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/applications/{id}/icon-image")
    @Produces({ "application/octet-stream" })
    public RestResponse<File> applicationResourceReadIconImage(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/applications/{id}/image")
    @Produces({ "application/octet-stream" })
    public RestResponse<File> applicationResourceReadImage(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/applications/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationData> applicationResourceUpdate(@PathParam("id") Long id,@Valid @NotNull ApplicationInputData applicationInputData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/applications")
    @Produces({ "application/json" })
    public RestResponse<PaginationListApplicationDataV2> applicationResourceV2Search(@QueryParam("applicationGroupId") Set<Long> applicationGroupId,
            @QueryParam("forDashboard") Boolean forDashboard, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("applicationGroup") String sortAttribute, @QueryParam("type") RelationShipKind type) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/masterdata/applications/{id}/icon-image")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    public RestResponse<Void> applicationResourceV3ChangeIconImage(@PathParam("id") Long id, @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/masterdata/applications/{id}/image")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    public RestResponse<Void> applicationResourceV3ChangeImage(@PathParam("id") Long id, @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/masterdata/applications")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationDataV3> applicationResourceV3Create(@Valid @NotNull ApplicationDataV3 applicationDataV3) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v3/masterdata/applications/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> applicationResourceV3Delete(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/masterdata/applications/{id}")
    @Produces({ "application/json" })
    public RestResponse<ApplicationDataV3> applicationResourceV3Read(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/masterdata/applications")
    @Produces({ "application/json" })
    public RestResponse<PaginationListApplicationDataV3> applicationResourceV3Search(@QueryParam("applicationGroupId") Set<Long> applicationGroupId,
            @QueryParam("forDashboard") Boolean forDashboard, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("applicationGroup") String sortAttribute, @QueryParam("type") RelationShipKind type) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v3/masterdata/applications/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationDataV3> applicationResourceV3Update(@PathParam("id") Long id,@Valid @NotNull ApplicationDataV3 applicationDataV3) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v4/masterdata/applications/{id}/icon-image")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    public RestResponse<Void> applicationResourceV4ChangeIconImage(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v4/masterdata/applications/{id}/image")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    public RestResponse<Void> applicationResourceV4ChangeImage(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v4/masterdata/applications")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationDataV4> applicationResourceV4Create(@Valid @NotNull ApplicationDataV4 applicationDataV4) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v4/masterdata/applications/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> applicationResourceV4Delete(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v4/masterdata/applications/{id}")
    @Produces({ "application/json" })
    public RestResponse<ApplicationDataV4> applicationResourceV4Read(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v4/masterdata/applications/{id}/icon-image")
    @Produces({ "application/octet-stream" })
    public RestResponse<File> applicationResourceV4ReadIconImage(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v4/masterdata/applications/{id}/image")
    @Produces({ "application/octet-stream" })
    public RestResponse<File> applicationResourceV4ReadImage(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v4/masterdata/applications")
    @Produces({ "application/json" })
    public RestResponse<PaginationListApplicationDataV4> applicationResourceV4Search(@QueryParam("applicationGroupId") Set<UUID> applicationGroupId,
            @QueryParam("forDashboard") Boolean forDashboard, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("product") String product,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("applicationGroup") String sortAttribute, @QueryParam("type") RelationShipKind type) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v4/masterdata/applications/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ApplicationDataV4> applicationResourceV4Update(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull ApplicationDataV4 applicationDataV4) {
        return RestResponse.ok();
    }

    @GET
    @Path("/contexts/applications")
    @Produces({ "application/json" })
    public RestResponse<List<ContextApplicationData>> contextApplicationResourceList(@QueryParam("applicationGroupId")   Set<Long> applicationGroupId,@QueryParam("forDashboard")   Boolean forDashboard,@QueryParam("includeImages")   Boolean includeImages) {
        return RestResponse.ok();
    }

    @POST
    @Path("/contexts/applications/{id}/favourite")
    @Produces({ "application/json" })
    public RestResponse<ContextApplicationData> contextApplicationResourceToggleFavourite(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/contexts/applications")
    @Produces({ "application/json" })
    public RestResponse<List<ContextApplicationDataV2>> contextApplicationResourceV2List(@QueryParam("applicationGroupId")   Set<Long> applicationGroupId,@QueryParam("forDashboard")   Boolean forDashboard) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/contexts/{contextId}/applications")
    @Produces({ "application/json" })
    public RestResponse<List<ContextApplicationDataV2>> contextApplicationResourceV2ListAll(
            @PathParam("contextId") @Pattern(regexp = "\\S") String contextId, @QueryParam("applicationGroupId") Set<Long> applicationGroupId,
            @QueryParam("forDashboard") Boolean forDashboard) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/contexts/{id}/favourite")
    @Produces({ "application/json" })
    public RestResponse<ContextApplicationData> contextApplicationResourceV2ToggleFavourite(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/contexts/applications")
    @Produces({ "application/json" })
    public RestResponse<List<ContextApplicationDataV3>> contextApplicationResourceV3List(
            @QueryParam("applicationGroupId") Set<Long> applicationGroupId, @QueryParam("forDashboard") Boolean forDashboard) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/contexts/{contextId}/applications")
    @Produces({ "application/json" })
    public RestResponse<List<ContextApplicationDataV3>> contextApplicationResourceV3ListAll(
            @PathParam("contextId") @Pattern(regexp = "\\S") String contextId, @QueryParam("applicationGroupId") Set<UUID> applicationGroupId,
            @QueryParam("forDashboard") Boolean forDashboard) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/contexts/applications/{id}/favourite")
    @Produces({ "application/json" })
    public RestResponse<ContextApplicationDataV3> contextApplicationResourceV3ToggleFavourite(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @POST
    @Path("/contexts/{contextId}/authorize")
    @Produces({ "application/json" })
    public RestResponse<UserTokenPrincipal> contextResourceAuthorize(@PathParam("contextId") @Pattern(regexp = "\\S") String contextId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/contexts")
    @Produces({ "application/json" })
    public RestResponse<List<ContextData1>> contextResourceList(@QueryParam("name") String name,
            @QueryParam("organizationUUID") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID organizationUUID) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/contexts/{contextId}/authorize")
    @Produces({ "application/json" })
    public RestResponse<UserTokenPrincipal> contextResourceV2Authorize(@PathParam("contextId") @Pattern(regexp="\\S") String contextId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/contexts")
    @Produces({ "application/json" })
    public RestResponse<List<AuthorizationContextDataV2>> contextResourceV2List(@QueryParam("name")   String name,@QueryParam("organizationUUID") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")   UUID organizationUUID) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/contexts/{contextId}/authorize")
    @Produces({ "application/json" })
    public RestResponse<UserTokenPrincipal> contextResourceV3Authorize(@PathParam("contextId") @Pattern(regexp="\\S") String contextId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/contexts")
    @Produces({ "application/json" })
    public RestResponse<List<AuthorizationContextDataV3>> contextResourceV3List(@QueryParam("name")   String name,@QueryParam("organizationUUID") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")   UUID organizationUUID) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/contexts/{contextId}/favourite")
    @Produces({ "application/json" })
    public RestResponse<AuthorizationContextDataV3> contextResourceV3ToggleFavourite(@PathParam("contextId") @Pattern(regexp="\\S") String contextId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/countries")
    @Produces({ "application/json" })
    public RestResponse<List<CountryData>> countryResourceListCountries(@QueryParam("includeFlags")   Boolean includeFlags) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/countries/{iso2}/flag")
    @Produces({ "image/svg+xml" })
    public RestResponse<File> countryResourceReadFlag(@PathParam("iso2") @Pattern(regexp="[A-Z]{2}") String iso2) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/countries/start-sync")
    @Produces({ "application/json" })
    public RestResponse<Void> countryResourceStartSync() {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/domain-realm-mappings")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DomainRealmMappingData> domainRealmMappingResourceCreate(@Valid @NotNull DomainRealmMappingData domainRealmMappingData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/masterdata/domain-realm-mappings/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> domainRealmMappingResourceDelete(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/domain-realm-mappings/{id}")
    @Produces({ "application/json" })
    public RestResponse<DomainRealmMappingData> domainRealmMappingResourceRead(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/domain-realm-mappings")
    @Produces({ "application/json" })
    public RestResponse<PaginationListDomainRealmMappingData> domainRealmMappingResourceSearch(@QueryParam("domain") String domain,
            @QueryParam("external") Boolean external, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("realm") String realm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("external") String sortAttribute) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/domain-realm-mappings/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DomainRealmMappingData> domainRealmMappingResourceUpdate(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull DomainRealmMappingData domainRealmMappingData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/external-organizations/import")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> externalOrganizationResourceImportOrganizations(@Valid @NotNull ExternalOrganizationImportRequestData externalOrganizationImportRequestData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/external-organizations")
    @Produces({ "application/json" })
    public RestResponse<PaginationListExternalOrganizationData> externalOrganizationResourceSearch(
            @QueryParam("applicationId") List<Long> applicationId, @QueryParam("createDateTimeMax") Date createDateTimeMax,
            @QueryParam("createDateTimeMin") Date createDateTimeMin, @QueryParam("hasOrganization") Boolean hasOrganization,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax,
            @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin, @QueryParam("name") String name,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("id") String sortAttribute, @QueryParam("type") String type) {
        return RestResponse.ok();
    }

    @POST
    @Path("/external-organizations/start-sync")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> externalOrganizationResourceSync(@Valid @NotNull IDLongListInputData idLongListInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/external-organizations/import")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> externalOrganizationResourceV2ImportOrganizations(
            @Valid @NotNull ExternalOrganizationImportRequestDataV2 externalOrganizationImportRequestDataV2) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/external-organizations")
    @Produces({ "application/json" })
    public RestResponse<PaginationListExternalOrganizationDataV2> externalOrganizationResourceV2Search(
            @QueryParam("applicationId") List<UUID> applicationId, @QueryParam("createDateTimeMax") Date createDateTimeMax,
            @QueryParam("createDateTimeMin") Date createDateTimeMin, @QueryParam("hasOrganization") Boolean hasOrganization,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax,
            @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin, @QueryParam("name") String name,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("id") String sortAttribute, @QueryParam("type") String type) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/external-organizations/start-sync")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> externalOrganizationResourceV2Sync(@Valid @NotNull IDLongListInputData idLongListInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/external-profiles/import")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> externalProfileResourceImportProfiles(@Valid @NotNull ExternalProfileImportRequestData externalProfileImportRequestData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/external-profiles")
    @Produces({ "application/json" })
    public RestResponse<List<ExternalProfileData>> externalProfileResourceListExternalProfiles(@QueryParam("email") @Size(max=255)   String email) {
        return RestResponse.ok();
    }

    @POST
    @Path("/external-profiles/start-sync")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> externalProfileResourceSync(@Valid @NotNull IDLongListInputData idLongListInputData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/external-profiles")
    @Produces({ "application/json" })
    public RestResponse<List<ExternalProfileData>> externalProfileResourceV2ListExternalProfiles(@QueryParam("email") @Size(max = 255) String email) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/external-profiles/start-sync")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<Void> externalProfileResourceV2Sync(@Valid @NotNull UUIDListInputData uuIDListInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/user_adapters/test/generic")
    @Produces({ "application/json" })
    public RestResponse<UserModelData> genericUserAdapterTestResourceCreateGenericUser(@QueryParam("email") @Size(max = 255) String email,
            @QueryParam("firstName") String firstName,
            @QueryParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @QueryParam("lastName") String lastName, @QueryParam("locale") String locale, @QueryParam("oicdId") String oicdId,
            @QueryParam("organizationId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID organizationId,
            @QueryParam("salutationId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID salutationId,
            @QueryParam("status") Status status, @QueryParam("tag") List<String> tag,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/user_adapters/test/generic/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> genericUserAdapterTestResourceDeleteGenericUser(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters/test/generic")
    @Produces({ "application/json" })
    public RestResponse<List<UserModelData>> genericUserAdapterTestResourceFindGenericUser(@QueryParam("email") String email,
            @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters/test/generic/{id}")
    @Produces({ "application/json" })
    public RestResponse<UserModelData> genericUserAdapterTestResourceGetGenericUser(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/user_adapters/test/generic/{id}")
    @Produces({ "application/json" })
    public RestResponse<UserModelData> genericUserAdapterTestResourceUpdateGenericUser(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @QueryParam("email") @Size(max = 255) String email, @QueryParam("firstName") String firstName,
            @QueryParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id2,
            @QueryParam("lastName") String lastName, @QueryParam("locale") String locale, @QueryParam("oicdId") String oicdId,
            @QueryParam("organizationId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID organizationId,
            @QueryParam("salutationId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID salutationId,
            @QueryParam("status") Status status, @QueryParam("tag") List<String> tag,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/herzberg/account-info")
    @Produces({ "application/json" })
    public RestResponse<AccountInfoData> herzbergAccountInfoResourceGetAccountInfo() {
        return RestResponse.ok();
    }

    @POST
    @Path("/herzberg/contexts/{contextId}/auth")
    @Produces({ "application/json" })
    public RestResponse<ContextTokenData> herzbergContextResourceAuth(@PathParam("contextId") @Pattern(regexp = "\\S") String contextId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/herzberg/contexts/context-info")
    @Produces({ "application/json" })
    public RestResponse<ContextData> herzbergContextResourceGetContextInfo() {
        return RestResponse.ok();
    }

    @GET
    @Path("/herzberg/contexts")
    @Produces({ "application/json" })
    public RestResponse<List<ContextData>> herzbergContextResourceSearchContexts(@QueryParam("name") String name,
            @QueryParam("organizationPortalId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID organizationPortalId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/herzberg/{instanceId}/auth")
    public RestResponse<Void> herzbergResourceAuthorize(@PathParam("instanceId") @Pattern(regexp="\\S") String instanceId,@QueryParam("callbackUri") @NotNull   URI callbackUri,@QueryParam("redirectUri") @NotNull   URI redirectUri) {
        return RestResponse.ok();
    }

    @POST
    @Path("/herzberg/{instanceId}/contexts/auto-auth")
    public RestResponse<Void> herzbergResourceAutoAuthorize(@PathParam("instanceId") @Pattern(regexp = "\\S") String instanceId,
            @QueryParam("contextId") String contextId,
            @QueryParam("organizationPortalId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID organizationPortalId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/herzberg/{instanceId}/callback")
    public RestResponse<Void> herzbergResourceCallback(@PathParam("instanceId") @Pattern(regexp="\\S") String instanceId,@QueryParam("code") @NotNull @Pattern(regexp="\\S")   String code,@QueryParam("state") @NotNull @Pattern(regexp="\\S")   String state) {
        return RestResponse.ok();
    }

    @POST
    @Path("/herzberg/{instanceId}/contexts/{contextId}/auth")
    public RestResponse<Void> herzbergResourceContextAuthorize(@PathParam("contextId") @Pattern(regexp="\\S") String contextId,@PathParam("instanceId") @Pattern(regexp="\\S") String instanceId) {
        return RestResponse.ok();
    }

    @POST
    @Path("/herzberg/{instanceId}/contexts/logout")
    public RestResponse<Void> herzbergResourceContextLogout(@PathParam("instanceId") @Pattern(regexp="\\S") String instanceId) {
        return RestResponse.ok();
    }

    @POST
    @Path("/herzberg/{instanceId}/logout")
    public RestResponse<Void> herzbergResourceLogout(@PathParam("instanceId") @Pattern(regexp = "\\S") String instanceId) {
        return RestResponse.ok();
    }

    @POST
    @Path("/herzberg/{instanceId}/token")
    @Produces({ "application/json" })
    public RestResponse<TokenData> herzbergResourceToken(@PathParam("instanceId") @Pattern(regexp="\\S") String instanceId) {
        return RestResponse.ok();
    }

    @POST
    @Path("/design-profiles/{profileId}/images/{type}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ImageDesignData> imageResourceCreateImage(@PathParam("profileId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID profileId,@PathParam("type") ImageType type,@Valid @NotNull ImageDesignData imageDesignData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/design-profiles/{profileId}/images/{type}")
    public RestResponse<Void> imageResourceDeleteImage(@PathParam("profileId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID profileId,@PathParam("type") ImageType type) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/{profileId}/images")
    @Produces({ "application/json" })
    public RestResponse<List<ImageDesignData>> imageResourceFindAllImagesByProfileId(@PathParam("profileId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID profileId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/{profileId}/images/{type}")
    @Produces({ "application/json" })
    public RestResponse<ImageDesignData> imageResourceGetImageByType(@PathParam("profileId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID profileId,@PathParam("type") ImageType type) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/design-profiles/{profileId}/images/{type}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ImageDesignData> imageResourceUpdateImage(@PathParam("profileId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID profileId,@PathParam("type") ImageType type,@Valid @NotNull ImageDesignData imageDesignData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/application-groups")
    @Produces({ "application/json" })
    public RestResponse<List<ApplicationGroupData>> masterdataResourceListApplicationGroups() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/rights")
    @Produces({ "application/json" })
    public RestResponse<List<RightCategoryData>> masterdataResourceListCategories() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/organization-types")
    @Produces({ "application/json" })
    public RestResponse<List<OrganizationTypeData>> masterdataResourceListOrganizationTypes() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/salutations")
    @Produces({ "application/json" })
    public RestResponse<List<SalutationData>> masterdataResourceListSalutations() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/supported-languages")
    @Produces({ "application/json" })
    public RestResponse<List<String>> masterdataResourceListSupportedLanguages() {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/organization-types")
    @Produces({ "application/json" })
    public RestResponse<List<OrganizationTypeDataV2>> masterdataResourceV2ListOrganizationTypes() {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/salutations")
    @Produces({ "application/json" })
    public RestResponse<List<SalutationDataV2>> masterdataResourceV2ListSalutations() {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/oidc-client-ids")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OIDCClientIdData> oIDCClientIdResourceCreate(@Valid @NotNull OIDCClientIdInputData oiDCClientIdInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/masterdata/oidc-client-ids/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> oIDCClientIdResourceDelete(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/oidc-client-ids")
    @Produces({ "application/json" })
    public RestResponse<OIDCClientIdData> oIDCClientIdResourceSearch(@QueryParam("application") @NotNull @Pattern(regexp="\\S")   String application,@QueryParam("host") @NotNull @Pattern(regexp="\\S")   String host) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/oidc-client-ids/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OIDCClientIdData> oIDCClientIdResourceUpdate(@PathParam("id") Long id,@Valid @NotNull OIDCClientIdInputData oiDCClientIdInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/masterdata/oidc-client-ids")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OIDCClientIdDataV2> oIDCClientIdResourceV2Create(@Valid @NotNull OIDCClientIdInputDataV2 oiDCClientIdInputDataV2) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v2/masterdata/oidc-client-ids/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> oIDCClientIdResourceV2Delete(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/oidc-client-ids")
    @Produces({ "application/json" })
    public RestResponse<OIDCClientIdDataV2> oIDCClientIdResourceV2Search(
            @QueryParam("application") @NotNull @Pattern(regexp = "\\S") String application,
            @QueryParam("host") @NotNull @Pattern(regexp = "\\S") String host) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v2/masterdata/oidc-client-ids/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OIDCClientIdDataV2> oIDCClientIdResourceV2Update(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull OIDCClientIdInputDataV2 oiDCClientIdInputDataV2) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/oidc-user-sync/create-keycloak-client")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ClientCredentialsData> oIDCUserSyncResourceCreateClient(
            @Valid @NotNull KeycloakClientRepresentationData keycloakClientRepresentationData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/oidc-user-sync/missing-keycloak-users/{keycloak-id}")
    @Produces({ "application/json" })
    public RestResponse<AccountData> oIDCUserSyncResourceCreateMissingKeyCloakUser(@PathParam("keycloak-id") @Pattern(regexp="\\S") String keycloakId) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/oidc-user-sync/missing-keycloak-users")
    @Produces({ "application/json" })
    public RestResponse<List<AccountData>> oIDCUserSyncResourceCreateMissingKeyCloakUsers() {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/oidc-user-sync/missing-portal-users/{keycloak-id}")
    @Produces({ "application/json" })
    public RestResponse<AccountData> oIDCUserSyncResourceCreateMissingPortalUser(@PathParam("keycloak-id") @Pattern(regexp="\\S") String keycloakId,@QueryParam("realm")   String realm) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/oidc-user-sync/missing-portal-users")
    @Produces({ "application/json" })
    public RestResponse<List<OIDCUserData>> oIDCUserSyncResourceCreateMissingPortalUsers() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/oidc-user-sync/mismatching-users")
    @Produces({ "application/json" })
    public RestResponse<List<OIDCUserData>> oIDCUserSyncResourceListMismatchingUsers() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/oidc-user-sync/missing-keycloak-users")
    @Produces({ "application/json" })
    public RestResponse<List<AccountData>> oIDCUserSyncResourceListMissingKeyCloakUsers() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/oidc-user-sync/missing-portal-users")
    @Produces({ "application/json" })
    public RestResponse<List<OIDCUserData>> oIDCUserSyncResourceListMissingPortalUsers() {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/oidc-user-sync/reset-client-secret/{keycloak-id}")
    @Produces({ "application/json" })
    public RestResponse<ClientCredentialsData> oIDCUserSyncResourceResetUserSecret(
            @PathParam("keycloak-id") @Pattern(regexp = "\\S") String keycloakId) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/oidc-user-sync/mismatching-users/{keycloak-id}")
    @Produces({ "application/json" })
    public RestResponse<AccountData> oIDCUserSyncResourceUpdateMismatchingUser(@PathParam("keycloak-id") @Pattern(regexp="\\S") String keycloakId,@QueryParam("realm")   String realm) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/oidc-user-sync/mismatching-users")
    @Produces({ "application/json" })
    public RestResponse<List<AccountData>> oIDCUserSyncResourceUpdateMismatchingUsers() {
        return RestResponse.ok();
    }

    @POST
    @Path("/organizations")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OrganizationDetailData> organizationResourceCreate(@Valid @NotNull OrganizationInputData organizationInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/organizations/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> organizationResourceDelete(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/organizations/{id}")
    @Produces({ "application/json" })
    public RestResponse<OrganizationDetailData> organizationResourceRead(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/organizations")
    @Produces({ "application/json" })
    public RestResponse<PaginationListOrganizationDetailData> organizationResourceSearch(@QueryParam("city") String city,
            @QueryParam("country") @Pattern(regexp = "[A-Z]{2}") String country, @QueryParam("createDateTimeMax") Date createDateTimeMax,
            @QueryParam("createDateTimeMin") Date createDateTimeMin, @QueryParam("deleted") Boolean deleted,
            @QueryParam("includeOfAnyContext") Boolean includeOfAnyContext, @QueryParam("isMandator") Boolean isMandator,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax,
            @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin, @QueryParam("matchCode") String matchCode,
            @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("streetAndNumber") String streetAndNumber,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantMatchCode") @Pattern(regexp = "[A-Z0-9]*") @Size(max = 100) String tenantMatchCode,
            @QueryParam("tenantName") String tenantName,
            @QueryParam("uuid") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID uuid,
            @QueryParam("zipCode") String zipCode) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/organizations/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OrganizationDetailData> organizationResourceUpdate(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@Valid @NotNull OrganizationInputData organizationInputData) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/organizations/{id}/design-profile")
    @Produces({ "application/json" })
    public RestResponse<Void> organizationResourceUpdateDesignProfile(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@QueryParam("profileId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")   UUID profileId) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/organizations")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OrganizationDetailDataV2> organizationResourceV2Create(@Valid @NotNull OrganizationInputDataV2 organizationInputDataV2) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v2/organizations/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> organizationResourceV2Delete(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/organizations/{id}")
    @Produces({ "application/json" })
    public RestResponse<OrganizationDetailDataV2> organizationResourceV2Read(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/organizations")
    @Produces({ "application/json" })
    public RestResponse<PaginationListOrganizationDetailDataV2> organizationResourceV2Search(
            @QueryParam("IANA conform time zone id. e.g. Europe/Berlin") String iaNAConformTimeZoneIdEGEuropeBerlin, @QueryParam("city") String city,
            @QueryParam("country") @Pattern(regexp = "[A-Z]{2}") String country, @QueryParam("createDateTimeMax") Date createDateTimeMax,
            @QueryParam("createDateTimeMin") Date createDateTimeMin, @QueryParam("deleted") Boolean deleted,
            @QueryParam("includeOfAnyContext") Boolean includeOfAnyContext, @QueryParam("isMandator") Boolean isMandator,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax,
            @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin, @QueryParam("matchCode") String matchCode,
            @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("streetAndNumber") String streetAndNumber,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantMatchCode") @Pattern(regexp = "[A-Z0-9]*") @Size(max = 100) String tenantMatchCode,
            @QueryParam("tenantName") String tenantName,
            @QueryParam("uuid") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID uuid,
            @QueryParam("zipCode") String zipCode) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v2/organizations/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<OrganizationDetailDataV2> organizationResourceV2Update(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull OrganizationInputDataV2 organizationInputDataV2) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v2/organizations/{id}/design-profile")
    @Produces({ "application/json" })
    public RestResponse<Void> organizationResourceV2UpdateDesignProfile(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @QueryParam("profileId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID profileId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/posts/alerts")
    @Produces({ "application/json" })
    public RestResponse<List<PostAlertResultData>> postAlertResourceSearchPostAlert(@QueryParam("languageTag")   String languageTag,@QueryParam("read")   Boolean read) {
        return RestResponse.ok();
    }

    @POST
    @Path("/posts")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<PostData> postResourceCreate(@Valid @NotNull PostInputData postInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/posts/{id}")
    @Produces({ "application/json" })
    public RestResponse<PostData> postResourceDelete(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/posts/{id}/read")
    @Produces({ "application/json" })
    public RestResponse<Void> postResourceMarkPostRead(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/posts/{id}/unread")
    @Produces({ "application/json" })
    public RestResponse<Void> postResourceMarkPostUnread(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/posts/{id}")
    @Produces({ "application/json" })
    public RestResponse<PostData> postResourceRead(@PathParam("id") Long id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/posts")
    @Produces({ "application/json" })
    public RestResponse<PaginationListPostData> postResourceSearch(@QueryParam("accessType") AccessType accessType,
            @QueryParam("categories") List<PostCategory> categories, @QueryParam("createDateTimeMax") Date createDateTimeMax,
            @QueryParam("createDateTimeMin") Date createDateTimeMin, @QueryParam("createUser") String createUser,
            @QueryParam("creatorContextId") String creatorContextId, @QueryParam("creatorContextType") String creatorContextType,
            @QueryParam("deleted") Boolean deleted, @QueryParam("isBanner") Boolean isBanner, @QueryParam("isBlogpost") Boolean isBlogpost,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("languageTags") List<String> languageTags,
            @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax, @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin,
            @QueryParam("lastUpdateUser") String lastUpdateUser, @QueryParam("onlyActive") Boolean onlyActive,
            @QueryParam("onlyExpired") Boolean onlyExpired, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("visibleFrom") String sortAttribute, @QueryParam("title") String title,
            @QueryParam("visibleFrom") Date visibleFrom, @QueryParam("visibleTo") Date visibleTo) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/posts/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<PostData> postResourceUpdate(@PathParam("id") Long id,@Valid @NotNull PostInputData postInputData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/products/kpi")
    @Produces({ "application/json" })
    public RestResponse<List<ProductTenantKpiData>> productResourceListProductKpis() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/products")
    @Produces({ "application/json" })
    public RestResponse<PaginationListProductData> productResourceListProducts(@QueryParam("description") String description,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("name") String name,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/account-profile-groups")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupData> profileGroupResourceCreate(@Valid @NotNull ProfileGroupInputData profileGroupInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/masterdata/account-profile-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> profileGroupResourceDelete(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/account-profile-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupData> profileGroupResourceRead(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/account-profile-groups")
    @Produces({ "application/json" })
    public RestResponse<PaginationListProfileGroupData> profileGroupResourceSearch(@QueryParam("deleted") Boolean deleted,
            @QueryParam("includeOfAnyContext") Boolean includeOfAnyContext, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("matchCode") String matchCode, @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("matchCode") String sortAttribute,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantName") String tenantName) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/account-profile-groups/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupData> profileGroupResourceUpdate(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@Valid @NotNull ProfileGroupInputData profileGroupInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/masterdata/account-profile-groups")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupDataV2> profileGroupResourceV2Create(@Valid @NotNull ProfileGroupInputDataV2 profileGroupInputDataV2) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v2/masterdata/account-profile-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> profileGroupResourceV2Delete(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/account-profile-groups/{id}")
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupDataV2> profileGroupResourceV2Read(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/masterdata/account-profile-groups")
    @Produces({ "application/json" })
    public RestResponse<PaginationListProfileGroupDataV2> profileGroupResourceV2Search(@QueryParam("deleted") Boolean deleted,
            @QueryParam("includeOfAnyContext") Boolean includeOfAnyContext, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("matchCode") String matchCode, @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("matchCode") String sortAttribute,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantName") String tenantName) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v2/masterdata/account-profile-groups/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupDataV2> profileGroupResourceV2Update(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull ProfileGroupInputDataV2 profileGroupInputDataV2) {
        return RestResponse.ok();
    }

    @POST
    @Path("/design-profiles")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignProfileData> profileResourceCreateDesignProfile(@Valid @NotNull DesignProfileInputData designProfileInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/design-profiles/{id}")
    public RestResponse<Void> profileResourceDeleteDesignProfile(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/current")
    @Produces({ "application/json" })
    public RestResponse<DesignProfileData> profileResourceGetDesignProfile() {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/{id}")
    @Produces({ "application/json" })
    public RestResponse<DesignProfileData> profileResourceGetDesignProfileById(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles")
    @Produces({ "application/json" })
    public RestResponse<PaginationListDesignProfileData> profileResourceSearch(@QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("tenantName") String tenantName) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/design-profiles/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignProfileData> profileResourceUpdateDesignProfile(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@Valid @NotNull DesignProfileInputData designProfileInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/profiles/{id}/avatar")
    @Consumes({ "multipart/form-data" })
    @Produces({ "image/png" })
    public RestResponse<File> profileResourceV2ChangeAvatar(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id, @FormParam(value = "file") InputStream _fileInputStream) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/profiles")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileDataV2> profileResourceV2Create(@Valid @NotNull ProfileInputDataV2 profileInputDataV2) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v2/profiles/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> profileResourceV2Delete(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v2/profiles/{id}/avatar")
    @Produces({ "application/json" })
    public RestResponse<Void> profileResourceV2DeleteAvatar(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/profiles/{id}")
    @Produces({ "application/json" })
    public RestResponse<ProfileDataV2> profileResourceV2Read(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/profiles/{id}/avatar")
    @Produces({ "image/png" })
    public RestResponse<File> profileResourceV2ReadImage(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/profiles")
    @Produces({ "application/json" })
    public RestResponse<PaginationListProfileDataV2> profileResourceV2Search(
            @QueryParam("accountId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId,
            @QueryParam("createDateTimeMax") Date createDateTimeMax, @QueryParam("createDateTimeMin") Date createDateTimeMin,
            @QueryParam("deleted") Boolean deleted, @QueryParam("department") @Size(min = 1) String department,
            @QueryParam("email") @Size(min = 1) String email, @QueryParam("fax") @Size(min = 1) String fax,
            @QueryParam("firstName") @Size(min = 1) String firstName, @QueryParam("includeServiceProviders") Boolean includeServiceProviders,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("lastName") @Size(min = 1) String lastName,
            @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax, @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin,
            @QueryParam("locale") @Pattern(regexp = "[a-z]{2}-[A-Z]{2}") String locale, @QueryParam("office") @Size(min = 1) String office,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("phone") @Size(min = 1) String phone, @QueryParam("position") @Size(min = 1) String position,
            @QueryParam("profileTagId") Set<UUID> profileTagId, @QueryParam("roleId") Long roleId, @QueryParam("salutationId") Long salutationId,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("email") String sortAttribute, @QueryParam("status") Boolean status,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantName") String tenantName) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v2/profiles/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileDataV2> profileResourceV2Update(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@Valid @NotNull ProfileInputDataV2 profileInputDataV2) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v3/profiles")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileDataV3> profileResourceV3Create(@Valid @NotNull ProfileCreateDataV3 profileCreateDataV3) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/v3/profiles/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> profileResourceV3Delete(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/profiles/{id}")
    @Produces({ "application/json" })
    public RestResponse<ProfileDataV3> profileResourceV3Read(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/profiles")
    @Produces({ "application/json" })
    public RestResponse<PaginationListProfileDataV3> profileResourceV3Search(
            @QueryParam("accountId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID accountId,
            @QueryParam("createDateTimeMax") Date createDateTimeMax, @QueryParam("createDateTimeMin") Date createDateTimeMin,
            @QueryParam("deleted") Boolean deleted, @QueryParam("department") @Size(min = 1) String department,
            @QueryParam("email") @Size(min = 1) String email, @QueryParam("fax") @Size(min = 1) String fax,
            @QueryParam("firstName") @Size(min = 1) String firstName, @QueryParam("includeServiceProviders") Boolean includeServiceProviders,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("lastName") @Size(min = 1) String lastName,
            @QueryParam("lastUpdateDateTimeMax") Date lastUpdateDateTimeMax, @QueryParam("lastUpdateDateTimeMin") Date lastUpdateDateTimeMin,
            @QueryParam("locale") @Pattern(regexp = "[a-z]{2}-[A-Z]{2}") String locale, @QueryParam("office") @Size(min = 1) String office,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("phone") @Size(min = 1) String phone, @QueryParam("position") @Size(min = 1) String position,
            @QueryParam("salutationId") Long salutationId, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("email") String sortAttribute, @QueryParam("status") Boolean status,
            @QueryParam("tagId") Set<UUID> tagId,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantName") String tenantName) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v3/profiles/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileDataV3> profileResourceV3Update(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@Valid @NotNull ProfileUpdateDataV3 profileUpdateDataV3) {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/profile-tags")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileTagData> profileTagResourceCreate(@Valid @NotNull ProfileTagInputData profileTagInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/masterdata/profile-tags/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> profileTagResourceDelete(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/profile-tags/{id}")
    @Produces({ "application/json" })
    public RestResponse<ProfileTagData> profileTagResourceRead(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/profile-tags")
    @Produces({ "application/json" })
    public RestResponse<PaginationListProfileTagData> profileTagResourceSearch(@QueryParam("deleted") Boolean deleted,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("matchCode") String matchCode,
            @QueryParam("name") String name, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("searchTerm") String searchTerm,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("matchCode") String sortAttribute,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("tenantName") String tenantName) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/profile-tags/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ProfileTagData> profileTagResourceUpdate(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@Valid @NotNull ProfileTagInputData profileTagInputData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/account.change.avatar-update")
    @Produces({ "application/json" })
    public RestResponse<AccountMessageData> rMQResourceAcmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/account.change.email")
    @Produces({ "application/json" })
    public RestResponse<AccountEmailChangeMessageData> rMQResourceAecmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application-group.change.create")
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupMessageData> rMQResourceAgmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application-group.change.update")
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupMessageData> rMQResourceAgmd2() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application-group.change.delete")
    @Produces({ "application/json" })
    public RestResponse<ApplicationGroupMessageData> rMQResourceAgmd3() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application.change.create")
    @Produces({ "application/json" })
    public RestResponse<ApplicationMessageData> rMQResourceAmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application.change.update")
    @Produces({ "application/json" })
    public RestResponse<ApplicationMessageData> rMQResourceAmd2() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application.change.delete")
    @Produces({ "application/json" })
    public RestResponse<ApplicationMessageData> rMQResourceAmd3() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application.change.image-update")
    @Produces({ "application/json" })
    public RestResponse<ApplicationMessageData> rMQResourceAmd4() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/application.change.icon-image-update")
    @Produces({ "application/json" })
    public RestResponse<ApplicationMessageData> rMQResourceAmd5() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/organization.change.create")
    @Produces({ "application/json" })
    public RestResponse<OrganizationMessageData> rMQResourceOmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/organization.change.update")
    @Produces({ "application/json" })
    public RestResponse<OrganizationMessageData> rMQResourceOmd2() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/organization.change.delete")
    @Produces({ "application/json" })
    public RestResponse<OrganizationMessageData> rMQResourceOmd3() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile-group.change.create")
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupMessageData> rMQResourcePgmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile-group.change.update")
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupMessageData> rMQResourcePgmd2() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile-group.change.delete")
    @Produces({ "application/json" })
    public RestResponse<ProfileGroupMessageData> rMQResourcePgmd3() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile.change.create")
    @Produces({ "application/json" })
    public RestResponse<ProfileMessageData> rMQResourcePmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile.change.update")
    @Produces({ "application/json" })
    public RestResponse<ProfileMessageData> rMQResourcePmd2() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile.change.delete")
    @Produces({ "application/json" })
    public RestResponse<ProfileMessageData> rMQResourcePmd3() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile-tag.change.create")
    @Produces({ "application/json" })
    public RestResponse<ProfileTagMessageData> rMQResourcePtmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile-tag.change.update")
    @Produces({ "application/json" })
    public RestResponse<ProfileTagMessageData> rMQResourcePtmd2() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/profile-tag.change.delete")
    @Produces({ "application/json" })
    public RestResponse<ProfileTagMessageData> rMQResourcePtmd3() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/tenant.change.create")
    @Produces({ "application/json" })
    public RestResponse<TenantMessageData> rMQResourceTmd1() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/tenant.change.update")
    @Produces({ "application/json" })
    public RestResponse<TenantMessageData> rMQResourceTmd2() {
        return RestResponse.ok();
    }

    @GET
    @Path("/rmq/portal-service.application-event/tenant.change.delete")
    @Produces({ "application/json" })
    public RestResponse<TenantMessageData> rMQResourceTmd3() {
        return RestResponse.ok();
    }

    @POST
    @Path("/masterdata/service-links")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ServiceLinkData> serviceLinkResourceCreate(@Valid @NotNull ServiceLinkInputData serviceLinkInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/masterdata/service-links/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> serviceLinkResourceDelete(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/service-links")
    @Produces({ "application/json" })
    public RestResponse<List<ServiceLinkData>> serviceLinkResourceList() {
        return RestResponse.ok();
    }

    @GET
    @Path("/masterdata/service-links/{id}")
    @Produces({ "application/json" })
    public RestResponse<ServiceLinkData> serviceLinkResourceRead(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/masterdata/service-links/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<ServiceLinkData> serviceLinkResourceUpdate(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull ServiceLinkInputData serviceLinkInputData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/tenants/{id}/changed")
    @Produces({ "application/json" })
    public RestResponse<TenantChangedData> tenantResourceChanged(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@QueryParam("since") @NotNull   Date since) {
        return RestResponse.ok();
    }

    @POST
    @Path("/tenants")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<TenantData> tenantResourceCreate(@Valid @NotNull TenantCreateInputData tenantCreateInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/tenants/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> tenantResourceDelete(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/tenants/kpi")
    @Produces({ "application/json" })
    public RestResponse<List<TenantUsersApplicationsKpiData>> tenantResourceListTenantsKpi(
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("tenant") String sortAttribute) {
        return RestResponse.ok();
    }

    @GET
    @Path("/tenants/{id}")
    @Produces({ "application/json" })
    public RestResponse<TenantData> tenantResourceRead(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/tenants/applications")
    @Produces({ "application/json" })
    public RestResponse<List<TenantApplicationData>> tenantResourceReadApplications(@QueryParam("tenantId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")   UUID tenantId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/tenants/{id}/organizational-chart")
    @Produces({ "application/json" })
    public RestResponse<OrganizationalChartNodeData> tenantResourceReadOrganizationStructure(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/tenants")
    @Produces({ "application/json" })
    public RestResponse<PaginationListTenantData> tenantResourceSearch(@QueryParam("city") String city,
            @QueryParam("country") @Pattern(regexp = "[A-Z]{2}") String country, @QueryParam("customerAbbreviation") String customerAbbreviation,
            @QueryParam("deleted") Boolean deleted, @QueryParam("includeOfAnyContext") Boolean includeOfAnyContext,
            @QueryParam("jiraId") String jiraId, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("matchCode") String matchCode, @QueryParam("name") String name, @QueryParam("neoUrlName") String neoUrlName,
            @QueryParam("netboxId") String netboxId, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("salesforceId") String salesforceId,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("streetAndNumber") String streetAndNumber,
            @QueryParam("website") String website, @QueryParam("zipCode") String zipCode) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/tenants/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<TenantData> tenantResourceUpdate(@PathParam("id") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,@Valid @NotNull TenantData tenantData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/v2/tenants")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<TenantDataV2> tenantResourceV2Create(@Valid @NotNull TenantCreateInputDataV2 tenantCreateInputDataV2) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/tenants/{id}")
    @Produces({ "application/json" })
    public RestResponse<TenantDataV2> tenantResourceV2Read(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/tenants/applications")
    @Produces({ "application/json" })
    public RestResponse<List<TenantApplicationDataV2>> tenantResourceV2ReadApplications(@QueryParam("tenantId") @Pattern(regexp="[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")   UUID tenantId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v2/tenants")
    @Produces({ "application/json" })
    public RestResponse<PaginationListTenantDataV2> tenantResourceV2Search(@QueryParam("city") String city,
            @QueryParam("country") @Pattern(regexp = "[A-Z]{2}") String country, @QueryParam("customerAbbreviation") String customerAbbreviation,
            @QueryParam("deleted") Boolean deleted, @QueryParam("includeOfAnyContext") Boolean includeOfAnyContext,
            @QueryParam("jiraId") String jiraId, @QueryParam("language") @DefaultValue("en-US") String language,
            @QueryParam("matchCode") String matchCode, @QueryParam("name") String name, @QueryParam("neoUrlName") String neoUrlName,
            @QueryParam("netboxId") String netboxId, @QueryParam("page") @Min(0) @DefaultValue("1") Integer page,
            @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize, @QueryParam("salesforceId") String salesforceId,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("streetAndNumber") String streetAndNumber,
            @QueryParam("website") String website, @QueryParam("zipCode") String zipCode) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/v2/tenants/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<TenantDataV2> tenantResourceV2Update(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull TenantDataV2 tenantDataV2) {
        return RestResponse.ok();
    }

    @GET
    @Path("/v3/tenants/applications")
    @Produces({ "application/json" })
    public RestResponse<List<TenantApplicationDataV3>> tenantResourceV3ReadApplications(
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId) {
        return RestResponse.ok();
    }

    @POST
    @Path("/design-profiles/types/category-types")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignCategoryTypeData> typeResourceCreateCategoryType(
            @Valid @NotNull DesignCategoryTypeInputData designCategoryTypeInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/design-profiles/types/group-types")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignGroupTypeData> typeResourceCreateGroupType(@Valid @NotNull DesignGroupTypeInputData designGroupTypeInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/design-profiles/types/setting-types")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignSettingTypeData> typeResourceCreateSettingType(@Valid @NotNull DesignSettingTypeInputData designSettingTypeInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/design-profiles/types/category-types/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> typeResourceDeleteCategoryType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/design-profiles/types/group-types/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> typeResourceDeleteGroupType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/design-profiles/types/setting-types/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> typeResourceDeleteSettingType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/types/category-types")
    @Produces({ "application/json" })
    public RestResponse<List<DesignCategoryTypeData>> typeResourceListCategoryTypes(@QueryParam("key") String key,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("name") String name,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("sortOrder") Long sortOrder) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/types/group-types")
    @Produces({ "application/json" })
    public RestResponse<List<DesignGroupTypeData>> typeResourceListGroupTypes(
            @QueryParam("categoryTypeId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID categoryTypeId,
            @QueryParam("key") String key, @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("name") String name,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("sortOrder") Long sortOrder) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/types/setting-types")
    @Produces({ "application/json" })
    public RestResponse<List<DesignSettingTypeData>> typeResourceListSettingTypes(@QueryParam("key") String key,
            @QueryParam("language") @DefaultValue("en-US") String language, @QueryParam("name") String name,
            @QueryParam("page") @Min(0) @DefaultValue("1") Integer page, @QueryParam("pageSize") @Min(0) @DefaultValue("30") Integer pageSize,
            @QueryParam("searchTerm") String searchTerm, @QueryParam("sortAscending") @DefaultValue("false") Boolean sortAscending,
            @QueryParam("sortAttribute") @DefaultValue("name") String sortAttribute, @QueryParam("valueType") String valueType) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/types/category-types/{id}")
    @Produces({ "application/json" })
    public RestResponse<DesignCategoryTypeData> typeResourceReadCategoryType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/types/group-types/{id}")
    @Produces({ "application/json" })
    public RestResponse<DesignGroupTypeData> typeResourceReadGroupType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/design-profiles/types/setting-types/{id}")
    @Produces({ "application/json" })
    public RestResponse<DesignSettingTypeData> typeResourceReadSettingType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/design-profiles/types/category-types/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignCategoryTypeData> typeResourceUpdateCategoryType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull DesignCategoryTypeInputData designCategoryTypeInputData) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/design-profiles/types/group-types/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignGroupTypeData> typeResourceUpdateGroupType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull DesignGroupTypeInputData designGroupTypeInputData) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/design-profiles/types/setting-types/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<DesignSettingTypeData> typeResourceUpdateSettingType(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull DesignSettingTypeInputData designSettingTypeInputData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/user_adapters/configurations/{type}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<AdapterConfigurationData> userAdapterConfigurationResourceCreateUserAdapterConfiguration(@PathParam("type") AdapterType type,
            @Valid @NotNull AdapterConfigurationData adapterConfigurationData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters/configurations/{type}")
    @Produces({ "application/json" })
    public RestResponse<AdapterConfigurationData> userAdapterConfigurationResourceGetUserAdapterConfiguration(@PathParam("type") AdapterType type) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters/configurations")
    @Produces({ "application/json" })
    public RestResponse<List<AdapterConfigurationData>> userAdapterConfigurationResourceGetUserAdapterConfigurations() {
        return RestResponse.ok();
    }

    @PUT
    @Path("/user_adapters/configurations/{type}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<AdapterConfigurationData> userAdapterConfigurationResourceUpdateUserAdapterConfiguration(@PathParam("type") AdapterType type,
            @Valid @NotNull AdapterConfigurationData adapterConfigurationData) {
        return RestResponse.ok();
    }

    @POST
    @Path("/user_adapters")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<AdapterData> userAdapterResourceCreateUserAdapter(@Valid @NotNull AdapterInputData adapterInputData) {
        return RestResponse.ok();
    }

    @DELETE
    @Path("/user_adapters/{id}")
    @Produces({ "application/json" })
    public RestResponse<Void> userAdapterResourceDeleteUserAdapter(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters/{id}")
    @Produces({ "application/json" })
    public RestResponse<AdapterData> userAdapterResourceGetUserAdapter(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters")
    @Produces({ "application/json" })
    public RestResponse<List<AdapterData>> userAdapterResourceGetUserAdapters(@QueryParam("identifier") String identifier) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters/{identifier}/users")
    @Produces({ "application/json" })
    public RestResponse<List<AdapterUserData>> userAdapterResourceGetUsers(@PathParam("identifier") String identifier,
            @QueryParam("email") String email, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
            @QueryParam("searchTerm") String searchTerm,
            @QueryParam("tenantId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID tenantId,
            @QueryParam("userId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID userId) {
        return RestResponse.ok();
    }

    @GET
    @Path("/user_adapters/{identifier}/users/{userId}/sync")
    @Produces({ "application/json" })
    public RestResponse<AdapterUserData> userAdapterResourceSyncUser(@PathParam("identifier") String identifier,
            @PathParam("userId") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID userId) {
        return RestResponse.ok();
    }

    @PUT
    @Path("/user_adapters/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public RestResponse<AdapterData> userAdapterResourceUpdateUserAdapter(
            @PathParam("id") @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}") UUID id,
            @Valid @NotNull AdapterInputData adapterInputData) {
        return RestResponse.ok();
    }

    @GET
    @Path("/info/v1/version")
    @Produces({ "application/json" })
    public RestResponse<VersionInfoData> versionResourceGetVersion() {
        return RestResponse.ok();
    }
}
