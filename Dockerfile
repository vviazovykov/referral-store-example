FROM openjdk:11

MAINTAINER Hackathon Team

ARG HOME=/opt/referral-store

COPY build/libs/referral-store-1.0-SNAPSHOT.jar $HOME/
COPY scripts/wait-for-it.sh $HOME/scripts/

WORKDIR $HOME

EXPOSE 8082 8443

ENTRYPOINT [ "./scripts/wait-for-it.sh", "docker-mysql:3306", "--", "java", "-jar", "referral-store-1.0-SNAPSHOT.jar" ]