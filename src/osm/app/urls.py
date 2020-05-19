
from django.conf import settings
from django.conf.urls import include, url
from django.conf.urls.static import static

urlpatterns = [
    url(r'^sa/', include('shuup.admin.urls', namespace="shuup_admin", app_name="shuup_admin")),
    url(r'^api/', include('shuup.api.urls')),
    url(r'^', include('shuup.front.urls', namespace="shuup", app_name="shuup")),
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
