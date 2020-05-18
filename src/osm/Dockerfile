FROM node:11.14-slim

RUN apt-get update && \
    apt-get -y install python3 python3-pip python3-dev python3-pil && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY . /app

WORKDIR /app

RUN pip3 install shuup

RUN python3 manage.py migrate
RUN python3 manage.pyh shuup_init

RUN echo "from django.contrib.auth import get_user_model; User = get_user_model(); User.objects.create_superuser('admin', 'admin@admin.com', 'admin')" | python3 -m manage.py shell

EXPOSE 8000
CMD python3 manage.py createsuperuser runserver 0.0.0.0:8000